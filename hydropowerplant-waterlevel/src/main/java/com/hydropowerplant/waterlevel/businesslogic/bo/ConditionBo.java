package com.hydropowerplant.waterlevel.businesslogic.bo;

import com.hydropowerplant.waterlevel.ws.dto.DeviceLogDto;

public interface ConditionBo {

    /**
     * finds conditions connected to given device and sends them to scenario manager
     * <p>
     * persists device power level and log on database
     */
    void manageDevicePowerLevelCondition(DeviceLogDto deviceLogDto);

}
