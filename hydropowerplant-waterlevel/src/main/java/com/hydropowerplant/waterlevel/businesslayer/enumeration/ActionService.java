package com.hydropowerplant.waterlevel.businesslayer.enumeration;

import com.hydropowerplant.waterlevel.businesslayer.service.action.EmailActionBoImpl;
import com.hydropowerplant.waterlevel.businesslayer.service.action.PowerLevelActionBoImpl;
import com.hydropowerplant.waterlevel.businesslayer.service.action.SmsActionBoImpl;

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
