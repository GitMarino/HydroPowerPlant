package com.hydropowerplant.waterlevel.ws.controller.condition;

import com.hydropowerplant.waterlevel.businesslogic.object.event.DeviceEvent;
import com.hydropowerplant.waterlevel.businesslogic.service.condition.ConditionBo;
import com.hydropowerplant.waterlevel.ws.dto.ResponseDto;
import com.hydropowerplant.waterlevel.ws.dto.device.DeviceEventDto;
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

    private final ConditionBo conditionBo;

    public ConditionController(ConditionBo conditionBo) {
        this.conditionBo = conditionBo;
    }


    @PostMapping("/device")
    public ResponseEntity<ResponseDto> manageDeviceEvent(@Valid @RequestBody DeviceEventDto deviceEventDto) {
        conditionBo.manageDeviceEvent(new DeviceEvent(deviceEventDto.getRecordedAt(), deviceEventDto.getPowerLevel(), deviceEventDto.getSerial()));
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }

}
