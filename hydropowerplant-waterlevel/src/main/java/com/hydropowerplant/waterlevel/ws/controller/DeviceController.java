package com.hydropowerplant.waterlevel.ws.controller;

import com.hydropowerplant.waterlevel.businesslogic.bo.device.DeviceBo;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.ws.dto.DeviceDto;
import com.hydropowerplant.waterlevel.ws.dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final DeviceBo deviceBo;

    public DeviceController(DeviceBo deviceBo) {
        this.deviceBo = deviceBo;
    }
    

    @PostMapping
    public ResponseEntity<ResponseDto> createDevice(@Valid @RequestBody DeviceDto deviceDto) {
        deviceBo.saveDevice(new Device(deviceDto.getSerial(), deviceDto.getAddress(), deviceDto.getName(), deviceDto.getPowerLevel()));
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }

    @PatchMapping("{id}/powerLevel")
    public ResponseEntity<ResponseDto> setDevicePowerLevel(@PathVariable("id") final String serial, @RequestParam double powerLevel) {
        deviceBo.setPowerLevel(serial, powerLevel);
        return new ResponseEntity<>(new ResponseDto("Success!"), HttpStatus.OK);
    }
}
