package com.hydropowerplant.waterlevel.businesslayer.service.condition;

import com.hydropowerplant.waterlevel.businesslayer.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.condition.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelCondition;
import com.hydropowerplant.waterlevel.entity.device.Device;
import com.hydropowerplant.waterlevel.presentationlayer.dto.condition.PowerLevelConditionDto;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PowerLevelConditionBoImpl implements PowerLevelConditionBo {

    private final DeviceBo deviceBo;

    private final PowerLevelConditionDao powerLevelConditionDao;

    public PowerLevelConditionBoImpl(DeviceBo deviceBo, PowerLevelConditionDao powerLevelConditionDao) {
        this.deviceBo = deviceBo;
        this.powerLevelConditionDao = powerLevelConditionDao;
    }


    @Override
    public void createPowerLevelCondition(PowerLevelConditionDto powerLevelConditionDto) {
        Set<Device> devices = powerLevelConditionDto.getDevices().stream().map(deviceBo::getBySerial).collect(Collectors.toSet());
        powerLevelConditionDao.save(new PowerLevelCondition(null, powerLevelConditionDto.getName(), powerLevelConditionDto.getType(), devices));
    }

}
