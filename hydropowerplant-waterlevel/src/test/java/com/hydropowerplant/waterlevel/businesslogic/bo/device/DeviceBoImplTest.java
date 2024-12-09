package com.hydropowerplant.waterlevel.businesslogic.bo.device;

import com.hydropowerplant.waterlevel.businesslogic.exception.ItemNotFoundException;
import com.hydropowerplant.waterlevel.repository.device.DeviceDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeviceBoImplTest {

    @InjectMocks
    private DeviceBoImpl deviceBoImpl;

    @Mock
    private DeviceDao deviceDao;

    @Test
    public void setPowerLevelThrowsItemNotFoundExceptionTest() {
        // Arrange
        String serial = "cda899e-fb9c-47ad-9866";
        double powerLevel = 50.0;
        when(deviceDao.findById(serial)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ItemNotFoundException.class, () -> deviceBoImpl.setPowerLevel(serial, powerLevel));
    }


}