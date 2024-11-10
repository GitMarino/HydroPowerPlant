package com.hydropowerplant.waterlevel.businesslogic.service.condition;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.businesslogic.service.scenario.ScenarioBo;
import com.hydropowerplant.waterlevel.database.entity.Device;
import com.hydropowerplant.waterlevel.database.entity.Status;
import com.hydropowerplant.waterlevel.database.entity.condition.PowerLevelLimitCondition;
import com.hydropowerplant.waterlevel.repository.DeviceDao;
import com.hydropowerplant.waterlevel.repository.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.repository.PowerLevelLimitConditionDao;
import com.hydropowerplant.waterlevel.repository.StatusDao;
import com.hydropowerplant.waterlevel.web.dto.DeviceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private StatusDao statusDao;

    @Autowired
    private ScenarioBo scenarioBo;


    public void manageDevicePowerLevelCondition(DeviceStatus deviceStatus) {
        String deviceSerial = deviceStatus.getSerial();
        Optional<Device> optionalDevice = deviceDao.findBySerial(deviceSerial);
        if (optionalDevice.isEmpty()) {
            throw new ItemNotFoundException("No device found with serial " + deviceSerial);
        }
        List<Integer> conditions = getConditionsByDevice(deviceSerial, deviceStatus.getPowerLevel());
        if (!conditions.isEmpty()) {
            scenarioBo.startActions(conditions);
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
