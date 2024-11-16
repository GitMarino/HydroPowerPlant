package com.hydropowerplant.waterlevel.businesslogic.bo;

import com.hydropowerplant.waterlevel.ws.dto.DeviceStatus;

public interface ConditionBo {

    /**
     * finds conditions connected to given device and sends them to scenario manager
     * <p>
     * persists device status on database
     */
    void manageDevicePowerLevelCondition(DeviceStatus deviceStatus);

}
