package com.hydropowerplant.waterlevel.businesslayer.service.scenario;

import com.hydropowerplant.waterlevel.businesslayer.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.businesslayer.object.event.Event;
import com.hydropowerplant.waterlevel.businesslayer.service.action.ActionBoFactory;
import com.hydropowerplant.waterlevel.dataaccesslayer.ScenarioProjection;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.ScenarioDao;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.action.ActionDao;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.condition.ConditionDao;
import com.hydropowerplant.waterlevel.entity.Scenario;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ScenarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger log = LoggerFactory.getLogger(ScenarioBoImpl.class);

    @Override
    public void createScenario(ScenarioDto scenarioDto) {
        Set<Action> actions = scenarioDto.getActions().stream().map(this::getActionById).collect(Collectors.toSet());
        Set<Condition> conditions = scenarioDto.getConditions().stream().map(this::getConditionById).collect(Collectors.toSet());
        Scenario scenario = scenarioDao.save(new Scenario(null, actions, conditions, scenarioDto.getDescription(), scenarioDto.getEnabled(), scenarioDto.getName()));
        log.info("Scenario {} with id={} created", scenario.getName(), scenario.getId());
    }

    private Action getActionById(Integer actionId) {
        Optional<Action> optionalAction = actionDao.findById(actionId);
        if (optionalAction.isPresent()) {
            return optionalAction.get();
        }
        log.error("No action found with id={}", actionId);
        throw new ItemNotFoundException("No action found with id=" + actionId);
    }

    private Condition getConditionById(Integer conditionId) {
        Optional<Condition> optionalCondition = conditionDao.findById(conditionId);
        if (optionalCondition.isPresent()) {
            return optionalCondition.get();
        }
        log.error("No condition found with id={}", conditionId);
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
