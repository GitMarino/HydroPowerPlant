package com.hydropowerplant.waterlevel.businesslogic.bo.condition;

import com.hydropowerplant.waterlevel.businesslogic.bo.device.DeviceBo;
import com.hydropowerplant.waterlevel.businesslogic.bo.scenario.ScenarioBo;
import com.hydropowerplant.waterlevel.dao.condition.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.dao.condition.PowerLevelLimitConditionDao;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.DeviceLog;
import com.hydropowerplant.waterlevel.ws.dto.device.DeviceLogDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConditionBoImpl implements ConditionBo {

    private final PowerLevelConditionDao powerLevelConditionDao;

    private final PowerLevelLimitConditionDao powerLevelLimitConditionDao;

    private final DeviceBo deviceBo;

    private final ScenarioBo scenarioBo;

    public ConditionBoImpl(PowerLevelConditionDao powerLevelConditionDao, PowerLevelLimitConditionDao powerLevelLimitConditionDao,
                           DeviceBo deviceBo, ScenarioBo scenarioBo) {
        this.powerLevelConditionDao = powerLevelConditionDao;
        this.powerLevelLimitConditionDao = powerLevelLimitConditionDao;
        this.deviceBo = deviceBo;
        this.scenarioBo = scenarioBo;
    }
    

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
