package com.hydropowerplant.waterlevel.businesslogic.bo.action;

import com.hydropowerplant.waterlevel.businesslogic.object.ActionService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;

@Service
public class ActionBoFactory {

    private final BeanFactory beanFactory;

    public ActionBoFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    

    public ActionBo getActionBo(String actionType) {
        return beanFactory.getBean(ActionService.valueOf(actionType).getValue(), ActionBo.class);
    }

}
