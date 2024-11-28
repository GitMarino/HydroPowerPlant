package com.hydropowerplant.waterlevel.businesslogic.bo.device;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.dao.device.DeviceDao;
import com.hydropowerplant.waterlevel.dao.device.DeviceLogDao;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.DeviceLog;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceBoImpl implements DeviceBo {

    private final DeviceDao deviceDao;

    private final DeviceLogDao deviceLogDao;

    public DeviceBoImpl(DeviceDao deviceDao, DeviceLogDao deviceLogDao) {
        this.deviceDao = deviceDao;
        this.deviceLogDao = deviceLogDao;
    }
    

    public Device getDeviceBySerial(String serial) {
        Optional<Device> optionalDevice = deviceDao.findById(serial);
        if (optionalDevice.isPresent()) {
            return optionalDevice.get();
        }
        throw new ItemNotFoundException("No device found with serial:" + serial);
    }

    public void saveDevice(Device device) {
        deviceDao.save(device);
    }

    public void saveDeviceAndLog(Device device, DeviceLog deviceLog) {
        saveDevice(device);
        deviceLogDao.save(deviceLog);
    }

    public void setPowerLevel(String serial, double powerLevel) {
        if (deviceDao.updatePowerLevelBySerial(serial, powerLevel) == 0) {
            throw new ItemNotFoundException("No device found with serial:" + serial);
        }
    }

}
