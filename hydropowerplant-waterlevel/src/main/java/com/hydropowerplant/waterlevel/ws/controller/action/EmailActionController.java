package com.hydropowerplant.waterlevel.ws.controller.action;

import com.hydropowerplant.waterlevel.businesslogic.service.action.EmailActionBo;
import com.hydropowerplant.waterlevel.entity.action.EmailAction;
import com.hydropowerplant.waterlevel.ws.dto.ResponseDto;
import com.hydropowerplant.waterlevel.ws.dto.action.EmailActionDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emailAction")
public class EmailActionController {

    private final EmailActionBo emailActionBo;

    public EmailActionController(EmailActionBo emailActionBo) {
        this.emailActionBo = emailActionBo;
    }


    @PostMapping
    public ResponseEntity<ResponseDto> createEmailAction(@Valid @RequestBody EmailActionDto emailActionDto) {
        emailActionBo.saveEmailAction(new EmailAction(null, emailActionDto.getName(), emailActionDto.getType(),
                emailActionDto.getAddress(), emailActionDto.getSubject(), emailActionDto.getText()));
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }

}
