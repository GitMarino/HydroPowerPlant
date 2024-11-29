package com.hydropowerplant.waterlevel.ws.controller.action;

import com.hydropowerplant.waterlevel.businesslogic.bo.action.SmsActionBo;
import com.hydropowerplant.waterlevel.entity.action.SmsAction;
import com.hydropowerplant.waterlevel.ws.dto.ResponseDto;
import com.hydropowerplant.waterlevel.ws.dto.action.SmsActionDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smsAction")
public class SmsActionController {

    private final SmsActionBo smsActionBo;

    public SmsActionController(SmsActionBo smsActionBo) {
        this.smsActionBo = smsActionBo;
    }


    @PostMapping
    public ResponseEntity<ResponseDto> createSmsAction(@Valid @RequestBody SmsActionDto smsActionDto) {
        smsActionBo.saveSmsAction(new SmsAction(null, smsActionDto.getName(), smsActionDto.getType(),
                smsActionDto.getPhoneNumber(), smsActionDto.getPhoneNumber()));
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }

}