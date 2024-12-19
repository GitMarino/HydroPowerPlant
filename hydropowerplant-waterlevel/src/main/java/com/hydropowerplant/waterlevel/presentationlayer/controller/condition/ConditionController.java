package com.hydropowerplant.waterlevel.presentationlayer.controller.condition;

import com.hydropowerplant.waterlevel.businesslayer.object.event.DeviceEvent;
import com.hydropowerplant.waterlevel.businesslayer.service.CachedThreadPool;
import com.hydropowerplant.waterlevel.businesslayer.service.condition.ConditionBo;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ResponseDto;
import com.hydropowerplant.waterlevel.presentationlayer.dto.device.DeviceEventDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condition")
public class ConditionController {

    private final CachedThreadPool cachedThreadPool;

    private final ConditionBo conditionBo;

    public ConditionController(CachedThreadPool cachedThreadPool, ConditionBo conditionBo) {
        this.cachedThreadPool = cachedThreadPool;
        this.conditionBo = conditionBo;
    }


    @PostMapping("/device")
    public ResponseEntity<ResponseDto> manageDeviceEvent(@Valid @RequestBody DeviceEventDto deviceEventDto) {
        cachedThreadPool.getExecutor().execute(
                () -> conditionBo.manageDeviceEvent(new DeviceEvent(deviceEventDto.getRecordedAt(), deviceEventDto.getPowerLevel(), deviceEventDto.getSerial())));
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }

}
