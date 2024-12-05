package com.hydropowerplant.waterlevel.businesslogic.bo.device;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.dao.device.DeviceDao;
import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.ws.dto.PowerLevelDto;
import com.hydropowerplant.waterlevel.ws.dto.ResponseDto;
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

    public DeviceBoImpl(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }


    public Device getBySerial(String serial) {
        Optional<Device> optionalDevice = deviceDao.findById(serial);
        if (optionalDevice.isPresent()) {
            return optionalDevice.get();
        }
        throw new ItemNotFoundException("No device found with serial:" + serial);
    }

    public void saveDevice(Device device) {
        deviceDao.save(device);
    }

    public void setPowerLevel(String serial, double powerLevel) {
        Device device = getBySerial(serial);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("""
                eyJhbGciOiJIUZI1NiIsInR5cCI6IkpXVCJ9.
                eyJzdWIi0iIxMjMONTY3ODkwIiwibmFtZSI6IkpvaG4
                gRG91IiwiaXNTb2NpYWwiOnRydWV9.
                4pcPyMD09o1PSyXnrXCjTwXyr4BsezdI1AVTmud2fU4""");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PowerLevelDto> request = new HttpEntity<>(new PowerLevelDto(powerLevel), headers);

        RestTemplate restTemplate = new RestTemplate();
        try {
            //TODO column with url
            ResponseEntity<ResponseDto> response = restTemplate.exchange(
                    "https://host:9090/device/powerLevel", HttpMethod.PATCH, request, ResponseDto.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                updatePowerLevel(serial, powerLevel);
            }
        } catch (Exception e) {
            //TODO log error in api call
        }
    }

    public void updatePowerLevel(String serial, double powerLevel) {
        if (deviceDao.updatePowerLevelBySerial(serial, powerLevel) == 0) {
            throw new ItemNotFoundException("No device found with serial:" + serial);
        }
    }

}
