package com.hydropowerplant.waterlevel.businesslogic.object;

import com.hydropowerplant.waterlevel.businesslogic.bo.action.EmailActionBoImpl;
import com.hydropowerplant.waterlevel.businesslogic.bo.action.PowerLevelActionBoImpl;
import com.hydropowerplant.waterlevel.businesslogic.bo.action.SmsActionBoImpl;

public enum ActionService {

    EMAIL(EmailActionBoImpl.SERVICE_NAME),
    POWER_LEVEL(PowerLevelActionBoImpl.SERVICE_NAME),
    SMS(SmsActionBoImpl.SERVICE_NAME);

    private final String value;

    ActionService(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
