package com.hydropowerplant.waterlevel.businesslayer.service.condition;

import com.hydropowerplant.waterlevel.businesslayer.object.event.DeviceEvent;
import com.hydropowerplant.waterlevel.businesslayer.object.event.Event;
import com.hydropowerplant.waterlevel.businesslayer.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.businesslayer.service.device.DeviceLogBo;
import com.hydropowerplant.waterlevel.businesslayer.service.scenario.ScenarioBo;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.condition.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.condition.PowerLevelLimitConditionDao;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import com.hydropowerplant.waterlevel.entity.device.DeviceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

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

    public static final Logger log = LoggerFactory.getLogger(ConditionBoImpl.class);

    @Override
    public void manageDeviceEvent(DeviceEvent deviceEvent) {
        log.info("Device event [{}] occurred", deviceEvent);
        String serial = deviceEvent.getSerial();
        double powerLevel = deviceEvent.getPowerLevel();

        deviceBo.updatePowerLevel(serial, powerLevel);
        deviceLogBo.saveDeviceLog(
                new DeviceLog(null, deviceBo.getBySerial(serial), powerLevel, LocalDateTime.parse(deviceEvent.getRecordedAt())));

        Set<Condition> conditions = powerLevelConditionDao.findByDevicesSerial(serial);
        conditions.addAll(powerLevelLimitConditionDao.findByDevicesSerialAndMinPowerLevelGreaterThanOrMaxPowerLevelLessThan(serial, powerLevel, powerLevel));
        log.debug("{} conditions activated", conditions.size());
        performScenarios(conditions, deviceEvent);
    }

    private <T extends Event> void performScenarios(Set<Condition> conditions, T event) {
        if (!conditions.isEmpty()) {
            scenarioBo.performActions(conditions, event);
        }
    }

}
