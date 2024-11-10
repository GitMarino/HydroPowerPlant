package com.hydropowerplant.waterlevel.businesslogic.service.action;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionBoFactory {

    @Autowired
    private BeanFactory beanFactory;

    public ActionBo getActionBo(String actionType) {
        return beanFactory.getBean(getServiceName(actionType), ActionBo.class);
    }

    private String getServiceName(final String actionType) {
        return switch (actionType) {
            case "EMAIL" -> EmailActionBoImpl.SERVICE_NAME;
            case "POWER_LEVEL" -> PowerLevelActionBoImpl.SERVICE_NAME;
            case "SMS" -> SmsActionBoImpl.SERVICE_NAME;
            default -> throw new UnsupportedOperationException("Unsupported action type: " + actionType);
        };
    }

}
