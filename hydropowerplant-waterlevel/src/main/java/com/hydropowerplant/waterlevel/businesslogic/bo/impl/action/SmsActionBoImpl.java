package com.hydropowerplant.waterlevel.businesslogic.bo.impl.action;

import com.hydropowerplant.waterlevel.businesslogic.bo.ActionBo;
import com.hydropowerplant.waterlevel.entity.action.Action;
import org.springframework.stereotype.Service;

@Service(SmsActionBoImpl.SERVICE_NAME)
public class SmsActionBoImpl implements ActionBo {

    public static final String SERVICE_NAME = "smsAction";

    public void start(Action action) {
        //TODO
    }

}
