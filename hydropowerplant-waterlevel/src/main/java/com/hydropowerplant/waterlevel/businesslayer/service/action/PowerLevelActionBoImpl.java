package com.hydropowerplant.waterlevel.businesslayer.service.action;

import com.hydropowerplant.waterlevel.businesslayer.object.event.DeviceEvent;
import com.hydropowerplant.waterlevel.businesslayer.object.event.Event;
import com.hydropowerplant.waterlevel.businesslayer.service.CachedThreadPool;
import com.hydropowerplant.waterlevel.businesslayer.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.action.PowerLevelActionDao;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.PowerLevelAction;
import com.hydropowerplant.waterlevel.entity.device.Device;
import com.hydropowerplant.waterlevel.presentationlayer.dto.action.PowerLevelActionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service(PowerLevelActionBoImpl.SERVICE_NAME)
public class PowerLevelActionBoImpl implements ActionBo, PowerLevelActionBo {

    public static final String SERVICE_NAME = "powerLevelAction";

    private final CachedThreadPool cachedThreadPool;

    private final DeviceBo deviceBo;

    private final PowerLevelActionDao powerLevelActionDao;

    public PowerLevelActionBoImpl(CachedThreadPool cachedThreadPool, DeviceBo deviceBo, PowerLevelActionDao powerLevelActionDao) {
        this.cachedThreadPool = cachedThreadPool;
        this.deviceBo = deviceBo;
        this.powerLevelActionDao = powerLevelActionDao;
    }

    private static final Logger log = LoggerFactory.getLogger(PowerLevelActionBoImpl.class);

    @Override
    public void createPowerLevelAction(PowerLevelActionDto powerLevelActionDto) {
        Set<Device> devices = powerLevelActionDto.getDevices().stream().map(deviceBo::getBySerial).collect(Collectors.toSet());
        PowerLevelAction powerLevelAction = powerLevelActionDao.save(new PowerLevelAction(null, powerLevelActionDto.getName(), powerLevelActionDto.getType(), devices, powerLevelActionDto.getMultiplier()));
        log.info("Power level action created with id [{}]", powerLevelAction.getId());
    }

    @Override
    public <T extends Action, S extends Event> void start(T action, S event) {
        if (action instanceof PowerLevelAction powerLevelAction && event instanceof DeviceEvent deviceEvent) {
            double powerLevel = powerLevelAction.getMultiplier() * deviceEvent.getPowerLevel();
            for (Device device : powerLevelAction.getDevices()) {
                cachedThreadPool.getExecutor().execute(() -> deviceBo.setPowerLevel(device.getSerial(), powerLevel > 100 ? 100 : powerLevel));
            }
        }
    }
    
}
