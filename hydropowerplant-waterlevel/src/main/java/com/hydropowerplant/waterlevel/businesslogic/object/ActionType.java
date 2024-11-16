package com.hydropowerplant.waterlevel.businesslogic.object;

import com.hydropowerplant.waterlevel.businesslogic.bo.impl.action.EmailActionBoImpl;
import com.hydropowerplant.waterlevel.businesslogic.bo.impl.action.PowerLevelActionBoImpl;
import com.hydropowerplant.waterlevel.businesslogic.bo.impl.action.SmsActionBoImpl;
import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;

public enum ActionType {

    EMAIL("EMAIL", EmailActionBoImpl.SERVICE_NAME),
    POWER_LEVEL("POWER_LEVEL", PowerLevelActionBoImpl.SERVICE_NAME),
    SMS("SMS", SmsActionBoImpl.SERVICE_NAME);

    private final String value;

    private final String serviceName;

    ActionType(String value, String serviceName) {
        this.value = value;
        this.serviceName = serviceName;
    }

    public String getValue() {
        return value;
    }

    public String getServiceName() {
        return serviceName;
    }

    public static String getServiceNameByValue(String value) {
        for (ActionType type : ActionType.values()) {
            if (type.getValue().equals(value)) {
                return type.getServiceName();
            }
        }
        throw new ItemNotFoundException("No service found with value: " + value);
    }
}
