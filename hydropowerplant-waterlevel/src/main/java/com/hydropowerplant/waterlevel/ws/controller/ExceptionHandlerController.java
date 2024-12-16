package com.hydropowerplant.waterlevel.ws.controller;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.ws.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({ItemNotFoundException.class})
    public ResponseEntity<ResponseDto> handleDataBaseException(final ItemNotFoundException e) {
        return new ResponseEntity<>(new ResponseDto("Failure! " + e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
