package com.hydropowerplant.waterlevel.presentationlayer;

import com.hydropowerplant.waterlevel.businesslayer.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ResponseDto> handleItemNotFoundException(final ItemNotFoundException exception) {
        return new ResponseEntity<>(new ResponseDto("Failure! " + exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(final MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(new ResponseDto("Failure! " + buildMethodArgumentNotValidException(exception.getBindingResult().getFieldErrors())), HttpStatus.BAD_REQUEST);
    }

    private String buildMethodArgumentNotValidException(List<FieldError> fieldErrors) {
        if (!CollectionUtils.isEmpty(fieldErrors)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (FieldError fieldError : fieldErrors) {
                stringBuilder.append(String.format("%s: %s;", fieldError.getField(), fieldError.getDefaultMessage()));
            }
            return stringBuilder.toString();
        }
        return "";
    }

}
