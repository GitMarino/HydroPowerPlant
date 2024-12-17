package com.hydropowerplant.waterlevel.repository.scenario;

import com.hydropowerplant.waterlevel.entity.action.Action;

import java.util.Set;

public interface ScenarioProjection {

    Set<Action> getActions();
    
}
