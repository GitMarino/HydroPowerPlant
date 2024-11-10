package com.hydropowerplant.waterlevel.businesslogic.service.action;

import com.hydropowerplant.waterlevel.businesslogic.object.ActionContext;
import org.springframework.stereotype.Service;

@Service(SmsActionBoImpl.SERVICE_NAME)
public class SmsActionBoImpl implements ActionBo {

    public static final String SERVICE_NAME = "smsAction";

    public void start(ActionContext actionContext) {
        //TODO
    }

}
