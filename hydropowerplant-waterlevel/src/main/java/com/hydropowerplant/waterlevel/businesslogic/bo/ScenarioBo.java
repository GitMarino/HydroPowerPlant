package com.hydropowerplant.waterlevel.businesslogic.bo;

import com.hydropowerplant.waterlevel.ws.dto.ScenarioDto;

import java.util.List;

public interface ScenarioBo {

    void createScenario(ScenarioDto scenarioDto);

    void performActions(List<Integer> conditionIds);

}
