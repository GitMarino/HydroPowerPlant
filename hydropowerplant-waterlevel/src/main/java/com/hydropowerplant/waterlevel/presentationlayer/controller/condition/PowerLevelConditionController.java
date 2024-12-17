package com.hydropowerplant.waterlevel.presentationlayer.controller.condition;

import com.hydropowerplant.waterlevel.businesslayer.service.condition.PowerLevelConditionBo;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ResponseDto;
import com.hydropowerplant.waterlevel.presentationlayer.dto.condition.PowerLevelConditionDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condition/powerLevel")
public class PowerLevelConditionController {

    private final PowerLevelConditionBo powerLevelConditionBo;

    public PowerLevelConditionController(PowerLevelConditionBo powerLevelConditionBo) {
        this.powerLevelConditionBo = powerLevelConditionBo;
    }


    @PostMapping
    public ResponseEntity<ResponseDto> createPowerLevelCondition(@Valid @RequestBody PowerLevelConditionDto powerLevelConditionDto) {
        powerLevelConditionBo.createPowerLevelCondition(powerLevelConditionDto);
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }
    
}
