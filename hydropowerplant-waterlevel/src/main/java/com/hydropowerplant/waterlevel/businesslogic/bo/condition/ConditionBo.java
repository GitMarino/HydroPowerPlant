package com.hydropowerplant.waterlevel.businesslogic.bo.condition;

import com.hydropowerplant.waterlevel.ws.dto.device.DeviceLogDto;

public interface ConditionBo {

    /**
     * persists device power level and log on database
     * <p>
     * finds conditions connected to given device and sends them to scenario manager
     */
    void manageDevicePowerLevelCondition(DeviceLogDto deviceLogDto);

}
