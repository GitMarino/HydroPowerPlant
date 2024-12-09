package com.hydropowerplant.waterlevel.businesslogic.service.action;

import com.hydropowerplant.waterlevel.businesslogic.object.event.DeviceEvent;
import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.businesslogic.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.businesslogic.service.device.DeviceLogBo;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.PowerLevelAction;
import com.hydropowerplant.waterlevel.entity.relationship.DevicePowerLevelActionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelActionRelationshipKey;
import com.hydropowerplant.waterlevel.repository.action.PowerLevelActionDao;
import com.hydropowerplant.waterlevel.repository.device.DeviceDao;
import com.hydropowerplant.waterlevel.repository.relationship.DevicePowerLevelActionRelationshipDao;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(PowerLevelActionBoImpl.SERVICE_NAME)
public class PowerLevelActionBoImpl implements ActionBo, PowerLevelActionBo {

    public static final String SERVICE_NAME = "powerLevelAction";

    private final DeviceBo deviceBo;

    private final DevicePowerLevelActionRelationshipDao devicePowerLevelActionRelationshipDao;

    private final PowerLevelActionDao powerLevelActionDao;

    public PowerLevelActionBoImpl(DeviceBo deviceBo, DeviceDao deviceDao, DeviceLogBo deviceLogBo,
                                  DevicePowerLevelActionRelationshipDao devicePowerLevelActionRelationshipDao, PowerLevelActionDao powerLevelActionDao) {
        this.deviceBo = deviceBo;
        this.devicePowerLevelActionRelationshipDao = devicePowerLevelActionRelationshipDao;
        this.powerLevelActionDao = powerLevelActionDao;
    }


    @Override
    @Transactional
    public void createPowerLevelAction(PowerLevelAction powerLevelAction, List<String> devicesSerials) {
        PowerLevelAction powerLevelActionDb = powerLevelActionDao.save(powerLevelAction);
        createDevicePowerLevelActionRelationships(powerLevelAction, devicesSerials);
    }

    private void createDevicePowerLevelActionRelationships(PowerLevelAction powerLevelAction, List<String> devicesSerials) {
        Optional<Device> optionalDevice;
        for (String deviceSerial : devicesSerials) {
            devicePowerLevelActionRelationshipDao.save(new DevicePowerLevelActionRelationship(
                    new DevicePowerLevelActionRelationshipKey(deviceBo.getBySerial(deviceSerial), powerLevelAction)));
        }
    }

    @Override
    public <T extends Action, S extends Event> void start(T action, S event) {
        if (action instanceof PowerLevelAction powerLevelAction && event instanceof DeviceEvent deviceEvent) {
            double powerLevel = deviceEvent.getPowerLevel() * powerLevelAction.getMultiplier();
            if (powerLevel > 100) {
                powerLevel = 100;
            }
            for (String deviceSerial : devicePowerLevelActionRelationshipDao.findIdDeviceSerialByIdPowerLevelActionId(powerLevelAction.getId())) {
                deviceBo.setPowerLevel(deviceSerial, powerLevel);
            }
        }
    }
}
