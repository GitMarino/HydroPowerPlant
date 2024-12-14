package com.hydropowerplant.waterlevel.businesslogic.service.device;

import com.hydropowerplant.waterlevel.entity.device.Device;

public interface DeviceBo {

    Device getBySerial(String serial);

    void saveDevice(Device device);

    int setPowerLevel(String serial, double powerLevel);

    int updatePowerLevel(String serial, double powerLevel);

}
