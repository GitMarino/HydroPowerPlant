package com.hydropowerplant.waterlevel.businesslogic.bo;

import com.hydropowerplant.waterlevel.ws.dto.DeviceLogDto;

public interface ConditionBo {

    /**
     * persists device power level and log on database
     * <p>
     * finds conditions connected to given device and sends them to scenario manager
     */
    void manageDevicePowerLevelCondition(DeviceLogDto deviceLogDto);

}
