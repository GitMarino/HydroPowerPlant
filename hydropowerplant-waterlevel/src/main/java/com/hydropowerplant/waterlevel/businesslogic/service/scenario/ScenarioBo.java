package com.hydropowerplant.waterlevel.businesslogic.service.scenario;

import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import com.hydropowerplant.waterlevel.ws.dto.ScenarioDto;

import java.util.List;

public interface ScenarioBo {

    void createScenario(ScenarioDto scenarioDto);

    <S extends Event> void performActions(List<Condition> conditionsIds, S event);

}
