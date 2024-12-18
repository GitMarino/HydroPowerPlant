package com.hydropowerplant.waterlevel.businesslayer.service.condition;

import com.hydropowerplant.waterlevel.businesslayer.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.condition.PowerLevelConditionDao;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelCondition;
import com.hydropowerplant.waterlevel.entity.device.Device;
import com.hydropowerplant.waterlevel.presentationlayer.dto.condition.PowerLevelConditionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger log = LoggerFactory.getLogger(PowerLevelConditionBoImpl.class);

    @Override
    public void createPowerLevelCondition(PowerLevelConditionDto powerLevelConditionDto) {
        Set<Device> devices = powerLevelConditionDto.getDevices().stream().map(deviceBo::getBySerial).collect(Collectors.toSet());
        PowerLevelCondition powerLevelCondition = powerLevelConditionDao.save(new PowerLevelCondition(null, powerLevelConditionDto.getName(), powerLevelConditionDto.getType(), devices));
        log.info("PowerLevelCondition {} with id={} created", powerLevelCondition.getName(), powerLevelCondition.getId());
    }

}
