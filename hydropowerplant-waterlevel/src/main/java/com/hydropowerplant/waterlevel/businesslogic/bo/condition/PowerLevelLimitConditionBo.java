package com.hydropowerplant.waterlevel.businesslogic.bo.condition;

import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;

import java.util.List;

public interface PowerLevelLimitConditionBo {

    void createPowerLevelLimitCondition(PowerLevelLimitCondition powerLevelLimitCondition, List<String> devicesSerials);
}
