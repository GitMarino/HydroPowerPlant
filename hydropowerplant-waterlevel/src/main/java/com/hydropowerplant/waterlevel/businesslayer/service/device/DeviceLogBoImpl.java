package com.hydropowerplant.waterlevel.businesslayer.service.device;

import com.hydropowerplant.waterlevel.dataaccesslayer.repository.device.DeviceLogDao;
import com.hydropowerplant.waterlevel.entity.device.DeviceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeviceLogBoImpl implements DeviceLogBo {

    private final DeviceLogDao deviceLogDao;

    public DeviceLogBoImpl(DeviceLogDao deviceLogDao) {
        this.deviceLogDao = deviceLogDao;
    }

    public static final Logger log = LoggerFactory.getLogger(DeviceLogBoImpl.class);

    @Override
    public void saveDeviceLog(DeviceLog deviceLog) {
        DeviceLog deviceLogDB = deviceLogDao.save(deviceLog);
        log.info("Device log created with id [{}]", deviceLogDB.getId());
    }
    
}
