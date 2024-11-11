package com.hydropowerplant.waterlevel.businesslogic.service.condition;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.businesslogic.service.scenario.ScenarioBo;
import com.hydropowerplant.waterlevel.database.entity.Device;
import com.hydropowerplant.waterlevel.database.entity.DeviceLog;
import com.hydropowerplant.waterlevel.repository.DeviceDao;
import com.hydropowerplant.waterlevel.repository.DeviceLogDao;
import com.hydropowerplant.waterlevel.repository.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.repository.PowerLevelLimitConditionDao;
import com.hydropowerplant.waterlevel.web.dto.DeviceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConditionBoImpl implements ConditionBo {

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private PowerLevelConditionDao powerLevelConditionDao;

    @Autowired
    private PowerLevelLimitConditionDao powerLevelLimitConditionDao;

    @Autowired
    private DeviceLogDao deviceLogDao;

    @Autowired
    private ScenarioBo scenarioBo;
    
    @Transactional
    public void manageDevicePowerLevelCondition(DeviceStatus deviceStatus) {
        String deviceSerial = deviceStatus.getSerial();
        Optional<Device> optionalDevice = deviceDao.findBySerial(deviceSerial);
        if (optionalDevice.isEmpty()) {
            throw new ItemNotFoundException("No device found with serial " + deviceSerial);
        }
        Integer devicePowerLevel = deviceStatus.getPowerLevel();
        Device device = optionalDevice.get();
        device.setPowerLevel(devicePowerLevel);

        deviceDao.save(device);
        deviceLogDao.save(new DeviceLog(device, devicePowerLevel, LocalDateTime.parse(deviceStatus.getRecordedAt())));
        performScenarios(deviceSerial, devicePowerLevel);
    }

    private void performScenarios(String deviceSerial, Integer devicePowerLevel) {
        List<Integer> conditions = powerLevelConditionDao.findAllByDevice(deviceSerial);
        conditions.addAll(powerLevelLimitConditionDao.findAllByDeviceSerialAndPowerLevel(deviceSerial, devicePowerLevel));
        if (!conditions.isEmpty()) {
            scenarioBo.performActions(conditions);
        }
    }
}
