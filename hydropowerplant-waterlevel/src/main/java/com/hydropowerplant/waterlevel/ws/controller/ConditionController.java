package com.hydropowerplant.waterlevel.ws.controller;

import com.hydropowerplant.waterlevel.businesslogic.bo.ConditionBo;
import com.hydropowerplant.waterlevel.ws.dto.DeviceLogDto;
import com.hydropowerplant.waterlevel.ws.dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condition")
public class ConditionController {

    @Autowired
    private ConditionBo conditionBo;

    @PostMapping("/device/powerLevel")
    public ResponseEntity<ResponseDto> manageDevicePowerLevelCondition(@Valid @RequestBody DeviceLogDto deviceLogDto) {
        conditionBo.manageDevicePowerLevelCondition(deviceLogDto);
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }
}
