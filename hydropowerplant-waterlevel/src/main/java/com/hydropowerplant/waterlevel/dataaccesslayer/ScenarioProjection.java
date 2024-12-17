package com.hydropowerplant.waterlevel.dataaccesslayer;

import com.hydropowerplant.waterlevel.entity.action.Action;

import java.util.Set;

public interface ScenarioProjection {

    Set<Action> getActions();

}
