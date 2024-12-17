package com.hydropowerplant.waterlevel.presentationlayer.controller;

import com.hydropowerplant.waterlevel.businesslayer.service.scenario.ScenarioBo;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ResponseDto;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ScenarioDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scenario")
public class ScenarioController {

    private final ScenarioBo scenarioBo;

    public ScenarioController(ScenarioBo scenarioBo) {
        this.scenarioBo = scenarioBo;
    }


    @PostMapping
    public ResponseEntity<ResponseDto> createScenario(@Valid @RequestBody ScenarioDto scenarioDto) {
        scenarioBo.createScenario(scenarioDto);
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }

}
