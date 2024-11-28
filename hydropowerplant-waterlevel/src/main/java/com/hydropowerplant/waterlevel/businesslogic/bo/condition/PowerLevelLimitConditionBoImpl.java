package com.hydropowerplant.waterlevel.businesslogic.bo.condition;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.dao.condition.PowerLevelLimitConditionDao;
import com.hydropowerplant.waterlevel.dao.device.DeviceDao;
import com.hydropowerplant.waterlevel.dao.relationship.DevicePowerLevelLimitConditionRelationshipDao;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;
import com.hydropowerplant.waterlevel.entity.relationship.DevicePowerLevelLimitConditionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelLimitConditionRelationshipKey;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class PowerLevelLimitConditionBoImpl implements PowerLevelLimitConditionBo {

    private final DeviceDao deviceDao;

    private final DevicePowerLevelLimitConditionRelationshipDao devicePowerLevelLimitConditionRelationshipDao;

    private final PowerLevelLimitConditionDao powerLevelLimitConditionDao;

    public PowerLevelLimitConditionBoImpl(DeviceDao deviceDao, DevicePowerLevelLimitConditionRelationshipDao devicePowerLevelLimitConditionRelationshipDao, PowerLevelLimitConditionDao powerLevelLimitConditionDao) {
        this.deviceDao = deviceDao;
        this.devicePowerLevelLimitConditionRelationshipDao = devicePowerLevelLimitConditionRelationshipDao;
        this.powerLevelLimitConditionDao = powerLevelLimitConditionDao;
    }

    @Transactional
    public void createPowerLevelLimitCondition(PowerLevelLimitCondition powerLevelLimitCondition, List<String> devicesSerials) {
        PowerLevelLimitCondition powerLevelLimitConditionDb = powerLevelLimitConditionDao.save(powerLevelLimitCondition);
        createDevicePowerLevelLimitConditionRelationships(powerLevelLimitConditionDb, devicesSerials);
    }

    private void createDevicePowerLevelLimitConditionRelationships(PowerLevelLimitCondition powerLevelLimitCondition, List<String> devicesSerials) {
        Optional<Device> optionalDevice;
        for (String deviceSerial : devicesSerials) {
            optionalDevice = deviceDao.findById(deviceSerial);
            if (optionalDevice.isEmpty()) {
                throw new ItemNotFoundException("No device found with serial:" + deviceSerial);
            }
            devicePowerLevelLimitConditionRelationshipDao.save(new DevicePowerLevelLimitConditionRelationship(
                    new DevicePowerLevelLimitConditionRelationshipKey(optionalDevice.get(), powerLevelLimitCondition)));
        }
    }
}
