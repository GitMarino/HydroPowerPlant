package com.hydropowerplant.waterlevel.ws.controller;

import com.hydropowerplant.waterlevel.businesslogic.bo.ScenarioBo;
import com.hydropowerplant.waterlevel.ws.dto.ResponseDto;
import com.hydropowerplant.waterlevel.ws.dto.ScenarioDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scenario")
public class ScenarioController {

    @Autowired
    private ScenarioBo scenarioBo;

    @PostMapping
    public ResponseEntity<ResponseDto> createScenario(@Valid @RequestBody ScenarioDto scenarioDto) {
        scenarioBo.createScenario(scenarioDto);
        return new ResponseEntity<>(new ResponseDto("Success! Scenario created."), HttpStatus.OK);
    }

}
