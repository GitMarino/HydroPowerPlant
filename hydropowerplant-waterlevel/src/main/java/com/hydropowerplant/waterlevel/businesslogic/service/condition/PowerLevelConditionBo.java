package com.hydropowerplant.waterlevel.businesslogic.service.condition;

import com.hydropowerplant.waterlevel.entity.condition.PowerLevelCondition;

import java.util.List;

public interface PowerLevelConditionBo {

    void createPowerLevelCondition(PowerLevelCondition powerLevelCondition, List<String> devicesSerials);
}
