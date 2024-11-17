package com.hydropowerplant.waterlevel.businesslogic.bo;

import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.DeviceLog;

public interface DeviceBo {

    Device getDeviceBySerial(String serial);

    void saveDevice(Device device);

    void saveDeviceAndLog(Device device, DeviceLog deviceLog);

    void setPowerLevel(String serial, double powerLevel);
}
