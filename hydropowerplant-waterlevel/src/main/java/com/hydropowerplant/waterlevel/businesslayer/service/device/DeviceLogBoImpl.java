package com.hydropowerplant.waterlevel.businesslayer.service.device;

import com.hydropowerplant.waterlevel.dataaccesslayer.repository.device.DeviceLogDao;
import com.hydropowerplant.waterlevel.entity.device.DeviceLog;
import org.springframework.stereotype.Service;

@Service
public class DeviceLogBoImpl implements DeviceLogBo {

    private final DeviceLogDao deviceLogDao;

    public DeviceLogBoImpl(DeviceLogDao deviceLogDao) {
        this.deviceLogDao = deviceLogDao;
    }


    @Override
    public void saveDeviceLog(DeviceLog deviceLog) {
        deviceLogDao.save(deviceLog);
    }
    
}
