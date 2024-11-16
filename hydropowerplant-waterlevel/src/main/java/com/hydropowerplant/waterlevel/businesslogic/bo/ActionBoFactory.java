package com.hydropowerplant.waterlevel.businesslogic.bo;

import com.hydropowerplant.waterlevel.businesslogic.object.ActionType;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionBoFactory {

    @Autowired
    private BeanFactory beanFactory;

    public ActionBo getActionBo(String actionType) {
        return beanFactory.getBean(ActionType.getServiceNameByValue(actionType), ActionBo.class);
    }

}
