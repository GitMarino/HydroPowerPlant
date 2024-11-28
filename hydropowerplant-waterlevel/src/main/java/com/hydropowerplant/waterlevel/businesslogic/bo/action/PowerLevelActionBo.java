package com.hydropowerplant.waterlevel.businesslogic.bo.action;

import com.hydropowerplant.waterlevel.entity.action.PowerLevelAction;

import java.util.List;

public interface PowerLevelActionBo {

    void createPowerLevelAction(PowerLevelAction powerLevelAction, List<String> devicesSerials);

}
