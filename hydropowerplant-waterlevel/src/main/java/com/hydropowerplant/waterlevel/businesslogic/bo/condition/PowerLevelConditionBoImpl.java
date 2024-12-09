package com.hydropowerplant.waterlevel.businesslogic.bo.condition;

import com.hydropowerplant.waterlevel.businesslogic.bo.device.DeviceBo;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelCondition;
import com.hydropowerplant.waterlevel.entity.relationship.DevicePowerLevelConditionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelConditionRelationshipKey;
import com.hydropowerplant.waterlevel.repository.condition.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.repository.relationship.DevicePowerLevelConditionRelationshipDao;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PowerLevelConditionBoImpl implements PowerLevelConditionBo {

    private final DeviceBo deviceBo;

    private final DevicePowerLevelConditionRelationshipDao devicePowerLevelConditionRelationshipDao;

    private final PowerLevelConditionDao powerLevelConditionDao;

    public PowerLevelConditionBoImpl(DeviceBo deviceBo, DevicePowerLevelConditionRelationshipDao devicePowerLevelConditionRelationshipDao,
                                     PowerLevelConditionDao powerLevelConditionDao) {
        this.deviceBo = deviceBo;
        this.devicePowerLevelConditionRelationshipDao = devicePowerLevelConditionRelationshipDao;
        this.powerLevelConditionDao = powerLevelConditionDao;
    }


    @Override
    @Transactional
    public void createPowerLevelCondition(PowerLevelCondition powerLevelCondition, List<String> devicesSerials) {
        PowerLevelCondition powerLevelConditionDb = powerLevelConditionDao.save(powerLevelCondition);
        createDevicePowerLevelConditionRelationships(powerLevelConditionDb, devicesSerials);
    }

    private void createDevicePowerLevelConditionRelationships(PowerLevelCondition powerLevelCondition, List<String> devicesSerials) {
        Optional<Device> optionalDevice;
        for (String deviceSerial : devicesSerials) {
            devicePowerLevelConditionRelationshipDao.save(new DevicePowerLevelConditionRelationship(
                    new DevicePowerLevelConditionRelationshipKey(deviceBo.getBySerial(deviceSerial), powerLevelCondition)));
        }
    }
}
