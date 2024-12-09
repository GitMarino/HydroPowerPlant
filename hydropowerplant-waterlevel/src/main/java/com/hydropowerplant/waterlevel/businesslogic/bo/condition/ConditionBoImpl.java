package com.hydropowerplant.waterlevel.businesslogic.bo.condition;

import com.hydropowerplant.waterlevel.businesslogic.bo.device.DeviceBo;
import com.hydropowerplant.waterlevel.businesslogic.bo.device.DeviceLogBo;
import com.hydropowerplant.waterlevel.businesslogic.bo.scenario.ScenarioBo;
import com.hydropowerplant.waterlevel.businesslogic.object.event.DeviceEvent;
import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.entity.DeviceLog;
import com.hydropowerplant.waterlevel.repository.condition.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.repository.condition.PowerLevelLimitConditionDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConditionBoImpl implements ConditionBo {

    private final DeviceBo deviceBo;

    private final DeviceLogBo deviceLogBo;

    private final PowerLevelConditionDao powerLevelConditionDao;

    private final PowerLevelLimitConditionDao powerLevelLimitConditionDao;

    private final ScenarioBo scenarioBo;

    public ConditionBoImpl(DeviceBo deviceBo, DeviceLogBo deviceLogBo, PowerLevelConditionDao powerLevelConditionDao,
                           PowerLevelLimitConditionDao powerLevelLimitConditionDao, ScenarioBo scenarioBo) {
        this.deviceBo = deviceBo;
        this.deviceLogBo = deviceLogBo;
        this.powerLevelConditionDao = powerLevelConditionDao;
        this.powerLevelLimitConditionDao = powerLevelLimitConditionDao;
        this.scenarioBo = scenarioBo;
    }


    @Override
    public void manageDevicePowerLevelCondition(DeviceEvent deviceEvent) {
        String serial = deviceEvent.getSerial();
        double powerLevel = deviceEvent.getPowerLevel();

        deviceBo.updatePowerLevel(serial, powerLevel);
        deviceLogBo.saveDeviceLog(
                new DeviceLog(null, deviceBo.getBySerial(serial), powerLevel, LocalDateTime.parse(deviceEvent.getRecordedAt())));

        List<Integer> conditions = powerLevelConditionDao.findByDeviceSerial(serial);
        conditions.addAll(powerLevelLimitConditionDao.findByDeviceSerialAndPowerLevel(serial, powerLevel));
        performScenarios(conditions, deviceEvent);
    }

    private <T extends Event> void performScenarios(List<Integer> conditions, T event) {
        if (!conditions.isEmpty()) {
            scenarioBo.performActions(conditions, event);
        }
    }
}
