package com.hydropowerplant.waterlevel.businesslogic.service.action;

import com.hydropowerplant.waterlevel.businesslogic.object.event.DeviceEvent;
import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.businesslogic.service.CachedThreadPool;
import com.hydropowerplant.waterlevel.businesslogic.service.device.DeviceBo;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.PowerLevelAction;
import com.hydropowerplant.waterlevel.entity.device.Device;
import com.hydropowerplant.waterlevel.repository.action.PowerLevelActionDao;
import com.hydropowerplant.waterlevel.ws.dto.action.PowerLevelActionDto;
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


    @Override
    public void createPowerLevelAction(PowerLevelActionDto powerLevelActionDto) {
        Set<Device> devices = powerLevelActionDto.getDevices().stream().map(deviceBo::getBySerial).collect(Collectors.toSet());
        powerLevelActionDao.save(new PowerLevelAction(null, powerLevelActionDto.getName(), powerLevelActionDto.getType(), devices, powerLevelActionDto.getMultiplier()));
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
