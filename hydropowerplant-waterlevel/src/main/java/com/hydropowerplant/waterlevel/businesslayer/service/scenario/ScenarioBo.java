package com.hydropowerplant.waterlevel.businesslayer.service.scenario;

import com.hydropowerplant.waterlevel.businesslayer.object.event.Event;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ScenarioDto;

import java.util.Set;

public interface ScenarioBo {

    void createScenario(ScenarioDto scenarioDto);

    <S extends Event> void performActions(Set<Condition> conditions, S event);

}
