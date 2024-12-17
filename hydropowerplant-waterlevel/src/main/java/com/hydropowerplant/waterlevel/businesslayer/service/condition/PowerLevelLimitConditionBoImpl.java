package com.hydropowerplant.waterlevel.businesslayer.service.condition;

import com.hydropowerplant.waterlevel.businesslayer.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.condition.PowerLevelLimitConditionDao;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;
import com.hydropowerplant.waterlevel.entity.device.Device;
import com.hydropowerplant.waterlevel.presentationlayer.dto.condition.PowerLevelLimitConditionDto;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PowerLevelLimitConditionBoImpl implements PowerLevelLimitConditionBo {

    private final DeviceBo deviceBo;

    private final PowerLevelLimitConditionDao powerLevelLimitConditionDao;

    public PowerLevelLimitConditionBoImpl(DeviceBo deviceBo, PowerLevelLimitConditionDao powerLevelLimitConditionDao) {
        this.deviceBo = deviceBo;
        this.powerLevelLimitConditionDao = powerLevelLimitConditionDao;
    }

    
    @Override
    public void createPowerLevelLimitCondition(PowerLevelLimitConditionDto powerLevelLimitConditionDto) {
        Set<Device> devices = powerLevelLimitConditionDto.getDevices().stream().map(deviceBo::getBySerial).collect(Collectors.toSet());
        powerLevelLimitConditionDao.save(new PowerLevelLimitCondition(
                null, powerLevelLimitConditionDto.getName(), powerLevelLimitConditionDto.getType(), devices,
                powerLevelLimitConditionDto.getMaxPowerLevel(), powerLevelLimitConditionDto.getMinPowerLevel()));
    }

}
