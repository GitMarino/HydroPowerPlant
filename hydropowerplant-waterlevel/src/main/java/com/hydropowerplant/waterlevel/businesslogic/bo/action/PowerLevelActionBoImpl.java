package com.hydropowerplant.waterlevel.businesslogic.bo.action;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.dao.action.PowerLevelActionDao;
import com.hydropowerplant.waterlevel.dao.device.DeviceDao;
import com.hydropowerplant.waterlevel.dao.relationship.DevicePowerLevelActionRelationshipDao;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.PowerLevelAction;
import com.hydropowerplant.waterlevel.entity.relationship.DevicePowerLevelActionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelActionRelationshipKey;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(PowerLevelActionBoImpl.SERVICE_NAME)
public class PowerLevelActionBoImpl implements ActionBo, PowerLevelActionBo {

    public static final String SERVICE_NAME = "powerLevelAction";

    private final DeviceDao deviceDao;

    private final DevicePowerLevelActionRelationshipDao devicePowerLevelActionRelationshipDao;

    private final PowerLevelActionDao powerLevelActionDao;

    public PowerLevelActionBoImpl(DeviceDao deviceDao, DevicePowerLevelActionRelationshipDao devicePowerLevelActionRelationshipDao, PowerLevelActionDao powerLevelActionDao) {
        this.deviceDao = deviceDao;
        this.devicePowerLevelActionRelationshipDao = devicePowerLevelActionRelationshipDao;
        this.powerLevelActionDao = powerLevelActionDao;
    }

    public <T extends Action, S extends Event> void start(T action, Optional<S> event) {

    }

    public void createPowerLevelAction(PowerLevelAction powerLevelAction, List<String> devicesSerials) {
        PowerLevelAction powerLevelActionDb = powerLevelActionDao.save(powerLevelAction);
        createDevicePowerLevelActionRelationships(powerLevelAction, devicesSerials);
    }

    private void createDevicePowerLevelActionRelationships(PowerLevelAction powerLevelAction, List<String> devicesSerials) {
        Optional<Device> optionalDevice;
        for (String deviceSerial : devicesSerials) {
            optionalDevice = deviceDao.findById(deviceSerial);
            if (optionalDevice.isEmpty()) {
                throw new ItemNotFoundException("No device found with serial:" + deviceSerial);
            }
            devicePowerLevelActionRelationshipDao.save(new DevicePowerLevelActionRelationship(
                    new DevicePowerLevelActionRelationshipKey(optionalDevice.get(), powerLevelAction)));
        }
    }
}
