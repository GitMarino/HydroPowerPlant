package com.hydropowerplant.waterlevel.repository.device;

import com.hydropowerplant.waterlevel.entity.device.Device;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDao extends JpaRepository<Device, String> {

    @Modifying
    @Transactional
    @Query("UPDATE Device SET powerLevel = :powerLevel WHERE serial = :serial")
    int updatePowerLevelBySerial(@Param("serial") String serial, @Param("powerLevel") double powerLevel);
    
}
