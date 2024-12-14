package com.hydropowerplant.waterlevel.businesslogic.service.scenario;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.businesslogic.service.action.ActionBoFactory;
import com.hydropowerplant.waterlevel.businesslogic.service.condition.ConditionBo;
import com.hydropowerplant.waterlevel.entity.Scenario;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import com.hydropowerplant.waterlevel.repository.ScenarioDao;
import com.hydropowerplant.waterlevel.repository.action.ActionDao;
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

    private final ConditionBo conditionBo;

    private final ScenarioDao scenarioDao;

    public ScenarioBoImpl(ActionBoFactory actionBoFactory, ActionDao actionDao, ConditionBo conditionBo, ScenarioDao scenarioDao) {
        this.actionBoFactory = actionBoFactory;
        this.actionDao = actionDao;
        this.conditionBo = conditionBo;
        this.scenarioDao = scenarioDao;
    }


    @Override
    public void createScenario(ScenarioDto scenarioDto) {
        Set<Action> actions = scenarioDto.getActions().stream().map(this::findActionById).collect(Collectors.toSet());
        Set<Condition> conditions = scenarioDto.getConditions().stream().map(conditionBo::getById).collect(Collectors.toSet());
        scenarioDao.save(new Scenario(null, scenarioDto.getDescription(), actions, conditions, scenarioDto.getEnabled(), scenarioDto.getName()));
    }

    private Action findActionById(Integer actionId) {
        Optional<Action> optionalAction = actionDao.findById(actionId);
        if (optionalAction.isPresent()) {
            return optionalAction.get();
        }
        throw new ItemNotFoundException("No action found with id:" + actionId);
    }

    @Override
    public <S extends Event> void performActions(List<Condition> conditions, S event) {
        actionDao.findByScenarioEnabledTrueAndConditionIn(conditions)
                .parallelStream()
                .forEach(action -> actionBoFactory.getActionBo(action.getType()).start(action, event));
    }

}
