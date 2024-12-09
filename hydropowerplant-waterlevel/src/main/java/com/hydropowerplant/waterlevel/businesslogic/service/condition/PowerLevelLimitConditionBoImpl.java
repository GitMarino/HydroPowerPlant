package com.hydropowerplant.waterlevel.businesslogic.service.condition;

import com.hydropowerplant.waterlevel.businesslogic.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;
import com.hydropowerplant.waterlevel.entity.relationship.DevicePowerLevelLimitConditionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelLimitConditionRelationshipKey;
import com.hydropowerplant.waterlevel.repository.condition.PowerLevelLimitConditionDao;
import com.hydropowerplant.waterlevel.repository.relationship.DevicePowerLevelLimitConditionRelationshipDao;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class PowerLevelLimitConditionBoImpl implements PowerLevelLimitConditionBo {

    private final DeviceBo deviceBo;

    private final DevicePowerLevelLimitConditionRelationshipDao devicePowerLevelLimitConditionRelationshipDao;

    private final PowerLevelLimitConditionDao powerLevelLimitConditionDao;

    public PowerLevelLimitConditionBoImpl(DeviceBo deviceBo, DevicePowerLevelLimitConditionRelationshipDao devicePowerLevelLimitConditionRelationshipDao, PowerLevelLimitConditionDao powerLevelLimitConditionDao) {
        this.deviceBo = deviceBo;
        this.devicePowerLevelLimitConditionRelationshipDao = devicePowerLevelLimitConditionRelationshipDao;
        this.powerLevelLimitConditionDao = powerLevelLimitConditionDao;
    }

    
    @Override
    @Transactional
    public void createPowerLevelLimitCondition(PowerLevelLimitCondition powerLevelLimitCondition, List<String> devicesSerials) {
        PowerLevelLimitCondition powerLevelLimitConditionDb = powerLevelLimitConditionDao.save(powerLevelLimitCondition);
        createDevicePowerLevelLimitConditionRelationships(powerLevelLimitConditionDb, devicesSerials);
    }

    private void createDevicePowerLevelLimitConditionRelationships(PowerLevelLimitCondition powerLevelLimitCondition, List<String> devicesSerials) {
        Optional<Device> optionalDevice;
        for (String deviceSerial : devicesSerials) {
            devicePowerLevelLimitConditionRelationshipDao.save(new DevicePowerLevelLimitConditionRelationship(
                    new DevicePowerLevelLimitConditionRelationshipKey(deviceBo.getBySerial(deviceSerial), powerLevelLimitCondition)));
        }
    }
}
