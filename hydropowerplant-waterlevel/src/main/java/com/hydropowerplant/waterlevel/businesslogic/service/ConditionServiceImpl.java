package com.hydropowerplant.waterlevel.businesslogic.service;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.dao.DeviceRepository;
import com.hydropowerplant.waterlevel.dao.PowerLevelConditionRepository;
import com.hydropowerplant.waterlevel.dao.PowerLevelLimitConditionRepository;
import com.hydropowerplant.waterlevel.dao.StatusRepository;
import com.hydropowerplant.waterlevel.database.entity.Device;
import com.hydropowerplant.waterlevel.database.entity.Status;
import com.hydropowerplant.waterlevel.database.entity.condition.PowerLevelLimitCondition;
import com.hydropowerplant.waterlevel.web.dto.DeviceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConditionServiceImpl implements ConditionService {

    @Autowired
    private DeviceRepository deviceDao;

    @Autowired
    private PowerLevelConditionRepository powerLevelConditionDao;

    @Autowired
    private PowerLevelLimitConditionRepository powerLevelLimitConditionDao;

    @Autowired
    private StatusRepository statusDao;


    public void manageDevicePowerLevelCondition(DeviceStatus deviceStatus) {
        String deviceSerial = deviceStatus.getSerial();
        Optional<Device> optionalDevice = deviceDao.findBySerial(deviceSerial);
        if (optionalDevice.isEmpty()) {
            throw new ItemNotFoundException("No device found with serial " + deviceSerial);
        }
        List<Integer> conditions = getConditionsByDevice(deviceSerial, deviceStatus.getPowerLevel());
        if (!conditions.isEmpty()) {
            //pass conditions to scenario method
        }
        statusDao.save(new Status(optionalDevice.get(), deviceStatus.getPowerLevel(), LocalDateTime.parse(deviceStatus.getRecordedAt())));
    }

    private List<Integer> getConditionsByDevice(String deviceSerial, Integer devicePowerLevel) {
        List<Integer> conditions = powerLevelConditionDao.findPowerLevelConditionIdsByDevice(deviceSerial);
        conditions.addAll(powerLevelLimitConditionDao.findAllByDevice(deviceSerial).stream()
                .filter(powerLevelLimitCondition -> powerLevelLimitCondition.getMinPowerLevel() < devicePowerLevel
                        && powerLevelLimitCondition.getMaxPowerLevel() > devicePowerLevel)
                .map(PowerLevelLimitCondition::getId).toList());
        return conditions;
    }
}
