package com.hydropowerplant.waterlevel.businesslayer.service.device;

import com.hydropowerplant.waterlevel.businesslayer.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.device.DeviceDao;
import com.hydropowerplant.waterlevel.entity.device.Device;
import com.hydropowerplant.waterlevel.presentationlayer.dto.ResponseDto;
import com.hydropowerplant.waterlevel.presentationlayer.dto.device.PowerLevelDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class DeviceBoImpl implements DeviceBo {

    private final DeviceDao deviceDao;

    private final RestTemplate restTemplate;

    public DeviceBoImpl(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
        this.restTemplate = new RestTemplate();
    }

    public static final Logger log = LoggerFactory.getLogger(DeviceBoImpl.class);

    private static final String noDeviceFoundMessage = "No device found with serial [{}]";

    @Override
    public Device getBySerial(String serial) {
        Optional<Device> optionalDevice = deviceDao.findById(serial);
        if (optionalDevice.isPresent()) {
            return optionalDevice.get();
        }
        log.error(noDeviceFoundMessage, serial);
        throw new ItemNotFoundException("No device found with serial=" + serial);
    }

    @Override
    public void saveDevice(Device device) {
        deviceDao.save(device);
        log.info("Device created with serial [{}]", device.getSerial());
    }

    @Override
    public void setPowerLevel(String serial, double powerLevel) {
        Device device = getBySerial(serial);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("Ym9zY236Ym9zY28=");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PowerLevelDto> request = new HttpEntity<>(new PowerLevelDto(powerLevel), headers);

        ResponseEntity<ResponseDto> response = restTemplate.exchange(device.getAddress(), HttpMethod.PUT, request, ResponseDto.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            updatePowerLevel(serial, powerLevel);
        }
        log.info("Device with serial [{}] power level set to [{}]", device.getSerial(), powerLevel);
    }

    @Override
    public void updatePowerLevel(String serial, double powerLevel) {
        if (deviceDao.updatePowerLevelBySerial(serial, powerLevel) == 0) {
            log.error(noDeviceFoundMessage, serial);
            throw new ItemNotFoundException("No device found with serial=" + serial);
        }
    }

}
