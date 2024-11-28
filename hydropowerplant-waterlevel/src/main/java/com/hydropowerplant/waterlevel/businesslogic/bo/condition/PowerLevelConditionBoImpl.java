package com.hydropowerplant.waterlevel.businesslogic.bo.condition;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.dao.condition.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.dao.device.DeviceDao;
import com.hydropowerplant.waterlevel.dao.relationship.DevicePowerLevelConditionRelationshipDao;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelCondition;
import com.hydropowerplant.waterlevel.entity.relationship.DevicePowerLevelConditionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelConditionRelationshipKey;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PowerLevelConditionBoImpl implements PowerLevelConditionBo {

    private final DeviceDao deviceDao;

    private final DevicePowerLevelConditionRelationshipDao devicePowerLevelConditionRelationshipDao;

    private final PowerLevelConditionDao powerLevelConditionDao;

    public PowerLevelConditionBoImpl(DeviceDao deviceDao, DevicePowerLevelConditionRelationshipDao devicePowerLevelConditionRelationshipDao,
                                     PowerLevelConditionDao powerLevelConditionDao) {
        this.deviceDao = deviceDao;
        this.devicePowerLevelConditionRelationshipDao = devicePowerLevelConditionRelationshipDao;
        this.powerLevelConditionDao = powerLevelConditionDao;
    }

    @Transactional
    public void createPowerLevelCondition(PowerLevelCondition powerLevelCondition, List<String> devicesSerials) {
        PowerLevelCondition powerLevelConditionDb = powerLevelConditionDao.save(powerLevelCondition);
        createDevicePowerLevelConditionRelationships(powerLevelConditionDb, devicesSerials);
    }

    private void createDevicePowerLevelConditionRelationships(PowerLevelCondition powerLevelCondition, List<String> devicesSerials) {
        Optional<Device> optionalDevice;
        for (String deviceSerial : devicesSerials) {
            optionalDevice = deviceDao.findById(deviceSerial);
            if (optionalDevice.isEmpty()) {
                throw new ItemNotFoundException("No device found with serial:" + deviceSerial);
            }
            devicePowerLevelConditionRelationshipDao.save(new DevicePowerLevelConditionRelationship(
                    new DevicePowerLevelConditionRelationshipKey(optionalDevice.get(), powerLevelCondition)));
        }
    }
}
