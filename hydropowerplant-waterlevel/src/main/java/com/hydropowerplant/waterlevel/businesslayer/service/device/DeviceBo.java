package com.hydropowerplant.waterlevel.businesslayer.service.device;

import com.hydropowerplant.waterlevel.entity.device.Device;

public interface DeviceBo {

    Device getBySerial(String serial);

    void saveDevice(Device device);

    void setPowerLevel(String serial, double powerLevel);

    void updatePowerLevel(String serial, double powerLevel);

}
