package com.hydropowerplant.waterlevel.presentationlayer.controller.action;

import com.hydropowerplant.waterlevel.businesslayer.service.action.PowerLevelActionBo;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ResponseDto;
import com.hydropowerplant.waterlevel.presentationlayer.dto.action.PowerLevelActionDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action/powerLevel")
public class PowerLevelActionController {

    private final PowerLevelActionBo powerLevelActionBo;

    public PowerLevelActionController(PowerLevelActionBo powerLevelActionBo) {
        this.powerLevelActionBo = powerLevelActionBo;
    }


    @PostMapping
    public ResponseEntity<ResponseDto> createPowerLevelAction(@Valid @RequestBody PowerLevelActionDto powerLevelActionDto) {
        powerLevelActionBo.createPowerLevelAction(powerLevelActionDto);
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }
    
}
