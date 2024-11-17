package com.hydropowerplant.waterlevel.businesslogic.bo;

import com.hydropowerplant.waterlevel.entity.action.Action;

public interface ActionBo {

    <T extends Action> void start(T action);

}
