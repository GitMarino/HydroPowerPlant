package com.hydropowerplant.waterlevel.businesslogic.bo.condition;

import com.hydropowerplant.waterlevel.entity.condition.PowerLevelCondition;

import java.util.List;

public interface PowerLevelConditionBo {

    void createPowerLevelCondition(PowerLevelCondition powerLevelCondition, List<String> devicesSerials);
}
