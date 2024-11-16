package com.hydropowerplant.waterlevel.businesslogic.bo.impl;

import com.hydropowerplant.waterlevel.businesslogic.bo.ActionBoFactory;
import com.hydropowerplant.waterlevel.businesslogic.bo.ScenarioBo;
import com.hydropowerplant.waterlevel.dao.ActionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioBoImpl implements ScenarioBo {

    @Autowired
    private ActionDao actionDao;

    @Autowired
    private ActionBoFactory actionBoFactory;

    public void performActions(List<Integer> conditionIds) {
        actionDao.findByConditions(conditionIds)
                .parallelStream()
                .forEach(action -> actionBoFactory.getActionBo(action.getType()).start(action));
    }

}
