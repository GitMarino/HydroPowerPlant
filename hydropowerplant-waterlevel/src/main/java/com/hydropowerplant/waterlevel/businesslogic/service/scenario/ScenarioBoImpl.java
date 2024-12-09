package com.hydropowerplant.waterlevel.businesslogic.service.scenario;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.businesslogic.service.action.ActionBoFactory;
import com.hydropowerplant.waterlevel.entity.Scenario;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import com.hydropowerplant.waterlevel.entity.relationship.ScenarioActionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.ScenarioConditionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.ScenarioActionRelationshipKey;
import com.hydropowerplant.waterlevel.entity.relationship.key.ScenarioConditionRelationshipKey;
import com.hydropowerplant.waterlevel.repository.ScenarioDao;
import com.hydropowerplant.waterlevel.repository.action.ActionDao;
import com.hydropowerplant.waterlevel.repository.condition.ConditionDao;
import com.hydropowerplant.waterlevel.repository.relationship.ScenarioActionRelationshipDao;
import com.hydropowerplant.waterlevel.repository.relationship.ScenarioConditionRelationshipDao;
import com.hydropowerplant.waterlevel.ws.dto.ScenarioDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ScenarioBoImpl implements ScenarioBo {

    private final ActionBoFactory actionBoFactory;

    private final ActionDao actionDao;

    private final ConditionDao conditionDao;

    private final ScenarioActionRelationshipDao scenarioActionRelationshipDao;

    private final ScenarioConditionRelationshipDao scenarioConditionRelationshipDao;

    private final ScenarioDao scenarioDao;

    public ScenarioBoImpl(ActionBoFactory actionBoFactory, ActionDao actionDao, ConditionDao conditionDao, ScenarioActionRelationshipDao scenarioActionRelationshipDao,
                          ScenarioConditionRelationshipDao scenarioConditionRelationshipDao, ScenarioDao scenarioDao) {
        this.actionBoFactory = actionBoFactory;
        this.actionDao = actionDao;
        this.conditionDao = conditionDao;
        this.scenarioActionRelationshipDao = scenarioActionRelationshipDao;
        this.scenarioConditionRelationshipDao = scenarioConditionRelationshipDao;
        this.scenarioDao = scenarioDao;
    }


    @Override
    @Transactional
    public void createScenario(ScenarioDto scenarioDto) {
        Scenario scenario = scenarioDao.save(
                new Scenario(null, scenarioDto.getDescription(), scenarioDto.getEnabled(), scenarioDto.getName()));

        createScenarioConditionRelationships(scenario, scenarioDto.getConditionsIds());
        createScenarioActionRelationships(scenario, scenarioDto.getActionsIds());
    }

    private void createScenarioConditionRelationships(Scenario scenario, List<Integer> conditionsIds) {
        Optional<Condition> optionalCondition;
        for (Integer conditionId : conditionsIds) {
            optionalCondition = conditionDao.findById(conditionId);
            if (optionalCondition.isEmpty()) {
                throw new ItemNotFoundException("No condition found with id:" + conditionId);
            }
            scenarioConditionRelationshipDao.save(new ScenarioConditionRelationship(
                    new ScenarioConditionRelationshipKey(optionalCondition.get(), scenario)));
        }
    }

    private void createScenarioActionRelationships(Scenario scenario, List<Integer> actionsIds) {
        Optional<Action> optionalAction;
        for (Integer actionId : actionsIds) {
            optionalAction = actionDao.findById(actionId);
            if (optionalAction.isEmpty()) {
                throw new ItemNotFoundException("No action found with id:" + actionId);
            }
            scenarioActionRelationshipDao.save(new ScenarioActionRelationship(
                    new ScenarioActionRelationshipKey(optionalAction.get(), scenario)));
        }
    }

    @Override
    public <S extends Event> void performActions(List<Integer> conditionsIds, S event) {
        actionDao.findByScenarioEnabledTrueAndScenarioConditionRelationshipIdConditionIdIn(conditionsIds)
                .parallelStream()
                .forEach(action -> actionBoFactory.getActionBo(action.getType()).start(action, event));
    }

}
