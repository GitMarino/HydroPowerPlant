package com.hydropowerplant.waterlevel.businesslogic.service.condition;

import com.hydropowerplant.waterlevel.businesslogic.object.event.DeviceEvent;

public interface ConditionBo {

    /**
     * persists device power level and log on database
     * <p>
     * finds conditions connected to given device and performs related scenarios
     */
    void manageDeviceEvent(DeviceEvent deviceEvent);

}
