package com.hydropowerplant.waterlevel.businesslogic.service.action;

import com.hydropowerplant.waterlevel.businesslogic.object.ActionContext;
import org.springframework.stereotype.Service;

@Service(EmailActionBoImpl.SERVICE_NAME)
public class EmailActionBoImpl implements ActionBo {

    public static final String SERVICE_NAME = "emailAction";

    public void start(ActionContext actionContext) {
        //TODO
    }
}
