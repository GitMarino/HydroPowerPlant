package com.hydropowerplant.waterlevel.businesslogic.bo.device;

import com.hydropowerplant.waterlevel.entity.DeviceLog;
import com.hydropowerplant.waterlevel.repository.device.DeviceLogDao;
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
