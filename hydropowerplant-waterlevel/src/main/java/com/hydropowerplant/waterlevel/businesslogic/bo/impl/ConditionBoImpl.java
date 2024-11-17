package com.hydropowerplant.waterlevel.businesslogic.bo.impl;

import com.hydropowerplant.waterlevel.businesslogic.bo.ConditionBo;
import com.hydropowerplant.waterlevel.businesslogic.bo.DeviceBo;
import com.hydropowerplant.waterlevel.businesslogic.bo.ScenarioBo;
import com.hydropowerplant.waterlevel.dao.condition.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.dao.condition.PowerLevelLimitConditionDao;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.DeviceLog;
import com.hydropowerplant.waterlevel.ws.dto.DeviceLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConditionBoImpl implements ConditionBo {

    @Autowired
    private PowerLevelConditionDao powerLevelConditionDao;

    @Autowired
    private PowerLevelLimitConditionDao powerLevelLimitConditionDao;

    @Autowired
    private DeviceBo deviceBo;

    @Autowired
    private ScenarioBo scenarioBo;

    public void manageDevicePowerLevelCondition(DeviceLogDto deviceLogDto) {
        String deviceSerial = deviceLogDto.getSerial();
        double devicePowerLevel = deviceLogDto.getPowerLevel();

        Device device = deviceBo.getDeviceBySerial(deviceSerial);
        device.setPowerLevel(devicePowerLevel);

        deviceBo.saveDeviceAndLog(device, new DeviceLog(null, device, devicePowerLevel, LocalDateTime.parse(deviceLogDto.getRecordedAt())));
        performScenarios(deviceSerial, devicePowerLevel);
    }

    private void performScenarios(String deviceSerial, double devicePowerLevel) {
        List<Integer> conditions = powerLevelConditionDao.findByDeviceSerial(deviceSerial);
        conditions.addAll(powerLevelLimitConditionDao.findByDeviceSerialAndPowerLevel(deviceSerial, devicePowerLevel));
        if (!conditions.isEmpty()) {
            scenarioBo.performActions(conditions);
        }
    }
}
