package com.hydropowerplant.waterlevel.businesslogic.service.scenario;

import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import com.hydropowerplant.waterlevel.ws.dto.ScenarioDto;

import java.util.Set;

public interface ScenarioBo {

    void createScenario(ScenarioDto scenarioDto);

    <S extends Event> void performActions(Set<Condition> conditions, S event);

}
