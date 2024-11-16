package com.hydropowerplant.waterlevel.businesslogic.bo.impl;

import com.hydropowerplant.waterlevel.businesslogic.bo.DeviceBo;
import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.dao.DeviceDao;
import com.hydropowerplant.waterlevel.dao.DeviceLogDao;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.DeviceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceBoImpl implements DeviceBo {

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private DeviceLogDao deviceLogDao;

    public Device getDeviceBySerial(String serial) {
        Optional<Device> optionalDevice = deviceDao.findById(serial);
        if (optionalDevice.isEmpty()) {
            throw new ItemNotFoundException("No device found with serial " + serial);
        }
        return optionalDevice.get();
    }

    public void saveDeviceAndLog(Device device, DeviceLog deviceLog) {
        deviceDao.save(device);
        deviceLogDao.save(deviceLog);
    }

}
