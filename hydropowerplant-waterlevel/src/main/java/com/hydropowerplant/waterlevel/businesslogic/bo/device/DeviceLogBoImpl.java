package com.hydropowerplant.waterlevel.businesslogic.bo.device;

import com.hydropowerplant.waterlevel.dao.device.DeviceLogDao;
import com.hydropowerplant.waterlevel.entity.DeviceLog;
import org.springframework.stereotype.Service;

@Service
public class DeviceLogBoImpl implements DeviceLogBo {

    private final DeviceLogDao deviceLogDao;

    public DeviceLogBoImpl(DeviceLogDao deviceLogDao) {
        this.deviceLogDao = deviceLogDao;
    }


    public void saveDeviceLog(DeviceLog deviceLog) {
        deviceLogDao.save(deviceLog);
    }
}
