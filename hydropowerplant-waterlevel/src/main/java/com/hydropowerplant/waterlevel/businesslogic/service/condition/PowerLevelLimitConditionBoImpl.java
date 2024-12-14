package com.hydropowerplant.waterlevel.businesslogic.service.condition;

import com.hydropowerplant.waterlevel.businesslogic.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;
import com.hydropowerplant.waterlevel.entity.device.Device;
import com.hydropowerplant.waterlevel.repository.condition.PowerLevelLimitConditionDao;
import com.hydropowerplant.waterlevel.ws.dto.condition.PowerLevelLimitConditionDto;

import java.util.Set;
import java.util.stream.Collectors;

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
