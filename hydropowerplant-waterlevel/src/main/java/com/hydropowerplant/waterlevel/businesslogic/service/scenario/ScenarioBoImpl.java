package com.hydropowerplant.waterlevel.businesslogic.service.scenario;

import com.hydropowerplant.waterlevel.businesslogic.object.ActionContext;
import com.hydropowerplant.waterlevel.businesslogic.service.action.ActionBoFactory;
import com.hydropowerplant.waterlevel.database.entity.action.Action;
import com.hydropowerplant.waterlevel.repository.ActionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioBoImpl implements ScenarioBo {

    @Autowired
    private ActionDao actionDao;

    @Autowired
    private ActionBoFactory actionBoFactory;

    public void startActions(List<Integer> conditionIds) {
        actionDao.findAllByConditions(conditionIds).
                parallelStream().forEach(this::startAction);
    }

    private void startAction(Action action) {
        ActionContext actionContext = new ActionContext();
        switch (action.getType()) {
            case "EMAIL":
                actionContext.setAddress(action.getEmailAction().getAddress());
                actionContext.setSubject(action.getEmailAction().getSubject());
                actionContext.setText(action.getEmailAction().getText());
            case "POWER_LEVEL":
                actionContext.setFormula(action.getPowerLevelAction().getFormula());
            case "SMS":
                actionContext.setPhoneNumber(action.getSmsAction().getPhoneNumber());
                actionContext.setText(action.getSmsAction().getText());
        }
        actionBoFactory.getActionBo(action.getType()).start(actionContext);
    }

}
