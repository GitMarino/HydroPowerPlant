package com.hydropowerplant.waterlevel.businesslogic.service.scenario;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.businesslogic.service.action.ActionBoFactory;
import com.hydropowerplant.waterlevel.entity.Scenario;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import com.hydropowerplant.waterlevel.repository.action.ActionDao;
import com.hydropowerplant.waterlevel.repository.condition.ConditionDao;
import com.hydropowerplant.waterlevel.repository.scenario.ScenarioDao;
import com.hydropowerplant.waterlevel.repository.scenario.ScenarioProjection;
import com.hydropowerplant.waterlevel.ws.dto.ScenarioDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScenarioBoImpl implements ScenarioBo {

    private final ActionBoFactory actionBoFactory;

    private final ActionDao actionDao;

    private final ConditionDao conditionDao;

    private final ScenarioDao scenarioDao;

    public ScenarioBoImpl(ActionBoFactory actionBoFactory, ActionDao actionDao, ConditionDao conditionDao, ScenarioDao scenarioDao) {
        this.actionBoFactory = actionBoFactory;
        this.actionDao = actionDao;
        this.conditionDao = conditionDao;
        this.scenarioDao = scenarioDao;
    }


    @Override
    public void createScenario(ScenarioDto scenarioDto) {
        Set<Action> actions = scenarioDto.getActions().stream().map(this::getActionById).collect(Collectors.toSet());
        Set<Condition> conditions = scenarioDto.getConditions().stream().map(this::getConditionById).collect(Collectors.toSet());
        scenarioDao.save(new Scenario(null, scenarioDto.getDescription(), actions, conditions, scenarioDto.getEnabled(), scenarioDto.getName()));
    }

    private Action getActionById(Integer actionId) {
        Optional<Action> optionalAction = actionDao.findById(actionId);
        if (optionalAction.isPresent()) {
            return optionalAction.get();
        }
        throw new ItemNotFoundException("No action found with id=" + actionId);
    }

    private Condition getConditionById(Integer conditionId) {
        Optional<Condition> optionalCondition = conditionDao.findById(conditionId);
        if (optionalCondition.isPresent()) {
            return optionalCondition.get();
        }
        throw new ItemNotFoundException("No condition found with id=" + conditionId);
    }

    @Override
    public <S extends Event> void performActions(Set<Condition> conditions, S event) {
        List<ScenarioProjection> scenarioProjections = scenarioDao.findByEnabledTrueAndConditionsIn(conditions);
        for (ScenarioProjection scenarioProjection : scenarioProjections) {
            scenarioProjection.getActions().parallelStream()
                    .forEach(action -> actionBoFactory.getActionBo(action.getType()).start(action, event));
        }
    }

}
