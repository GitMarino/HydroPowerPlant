package com.hydropowerplant.waterlevel.businesslogic.bo.impl.action;

import com.hydropowerplant.waterlevel.businesslogic.bo.ActionBo;
import com.hydropowerplant.waterlevel.entity.action.Action;
import org.springframework.stereotype.Service;

@Service(PowerLevelActionBoImpl.SERVICE_NAME)
public class PowerLevelActionBoImpl implements ActionBo {

    public static final String SERVICE_NAME = "powerLevelAction";

    public <T extends Action> void start(T action) {
        //TODO
    }
}
