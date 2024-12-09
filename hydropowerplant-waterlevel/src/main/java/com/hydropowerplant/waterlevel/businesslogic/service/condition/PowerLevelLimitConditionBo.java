package com.hydropowerplant.waterlevel.businesslogic.service.condition;

import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;

import java.util.List;

public interface PowerLevelLimitConditionBo {

    void createPowerLevelLimitCondition(PowerLevelLimitCondition powerLevelLimitCondition, List<String> devicesSerials);
}
