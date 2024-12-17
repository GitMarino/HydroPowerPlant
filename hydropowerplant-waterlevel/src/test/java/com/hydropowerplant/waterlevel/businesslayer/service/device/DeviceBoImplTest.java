package com.hydropowerplant.waterlevel.businesslayer.service.device;

import com.hydropowerplant.waterlevel.businesslayer.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.device.DeviceDao;
import com.hydropowerplant.waterlevel.entity.device.Device;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeviceBoImplTest {

    @InjectMocks
    private DeviceBoImpl deviceBoImpl;

    @Mock
    private DeviceDao deviceDao;

    private final String serial = "1T18H4UR300158E";

    private final double powerLevel = 0.0;

    @Test
    void setPowerLevelThrowsItemNotFoundExceptionTest() {
        when(deviceDao.findById(serial)).thenReturn(Optional.empty());

        assertThrows(ItemNotFoundException.class, () -> deviceBoImpl.setPowerLevel(serial, powerLevel));
    }

    @Test
    void setPowerLevelThrowsRestClientExceptionExceptionTest() {
        // Arrange
        Device device = getDevice();

        when(deviceDao.findById(serial)).thenReturn(Optional.of(device));

        // Act & Assert
        assertThrows(RestClientException.class, () -> deviceBoImpl.setPowerLevel(serial, powerLevel));
    }

    private Device getDevice() {
        return new Device(serial, "https://siemens.iot.devices/device/1T18H4UR300158E",
                "Main inlet valve", 64.0);
    }

}