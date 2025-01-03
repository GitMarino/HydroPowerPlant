package com.hydropowerplant.waterlevel.presentationlayer.controller.condition;

import com.hydropowerplant.waterlevel.businesslayer.service.condition.PowerLevelLimitConditionBo;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ResponseDto;
import com.hydropowerplant.waterlevel.presentationlayer.dto.condition.PowerLevelLimitConditionDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condition/powerLevelLimit")
public class PowerLevelLimitConditionController {

    private final PowerLevelLimitConditionBo powerLevelLimitConditionBo;

    public PowerLevelLimitConditionController(PowerLevelLimitConditionBo powerLevelLimitConditionBo) {
        this.powerLevelLimitConditionBo = powerLevelLimitConditionBo;
    }


    @PostMapping
    public ResponseEntity<ResponseDto> createPowerLevelLimitCondition(@Valid @RequestBody PowerLevelLimitConditionDto powerLevelLimitConditionDto) {
        powerLevelLimitConditionBo.createPowerLevelLimitCondition(powerLevelLimitConditionDto);
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }

}
