package com.hydropowerplant.waterlevel.ws.controller;

import com.hydropowerplant.waterlevel.businesslogic.bo.ConditionBo;
import com.hydropowerplant.waterlevel.ws.dto.DeviceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condition")
public class ConditionController {

    @Autowired
    private ConditionBo conditionBo;

    //TODO return an object
    @PostMapping("/device/powerLevel")
    public ResponseEntity<String> manageDevicePowerLevelCondition(DeviceStatus deviceStatus) {
        conditionBo.manageDevicePowerLevelCondition(deviceStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
