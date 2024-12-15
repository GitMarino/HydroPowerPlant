package com.hydropowerplant.waterlevel.businesslogic.service.condition;

import com.hydropowerplant.waterlevel.businesslogic.object.event.DeviceEvent;
import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.businesslogic.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.businesslogic.service.device.DeviceLogBo;
import com.hydropowerplant.waterlevel.businesslogic.service.scenario.ScenarioBo;
import com.hydropowerplant.waterlevel.entity.device.DeviceLog;
import com.hydropowerplant.waterlevel.repository.condition.ConditionDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConditionBoImpl implements ConditionBo {

    private final ConditionDao conditionDao;

    private final DeviceBo deviceBo;

    private final DeviceLogBo deviceLogBo;

    private final ScenarioBo scenarioBo;

    public ConditionBoImpl(ConditionDao conditionDao, DeviceBo deviceBo, DeviceLogBo deviceLogBo, ScenarioBo scenarioBo) {
        this.conditionDao = conditionDao;
        this.deviceBo = deviceBo;
        this.deviceLogBo = deviceLogBo;
        this.scenarioBo = scenarioBo;
    }

    @Override
    public void manageDeviceEvent(DeviceEvent deviceEvent) {
        String serial = deviceEvent.getSerial();
        double powerLevel = deviceEvent.getPowerLevel();

        deviceBo.updatePowerLevel(serial, powerLevel);
        deviceLogBo.saveDeviceLog(
                new DeviceLog(null, deviceBo.getBySerial(serial), powerLevel, LocalDateTime.parse(deviceEvent.getRecordedAt())));

        List<Integer> conditions = conditionDao.findPowerLevelConditionByDevice(serial);
        conditions.addAll(conditionDao.findPowerLevelLimitConditionByDeviceAndPowerLevel(serial, powerLevel));
        performScenarios(conditions, deviceEvent);
    }

    private <T extends Event> void performScenarios(List<Integer> conditions, T event) {
        if (!conditions.isEmpty()) {
            scenarioBo.performActions(conditions, event);
        }
    }

}
