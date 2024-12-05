package com.hydropowerplant.waterlevel.dao.device;

import com.hydropowerplant.waterlevel.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceDao extends JpaRepository<Device, String> {

    @Query("SELECT d.serial " +
            "FROM Device d JOIN PowerLevelAction pla " +
            "WHERE pla.id.powerLevelAction=?1")
    List<String> findByPowerLevelAction(Integer powerLevelActionId);

    @Modifying
    @Query("UPDATE Device SET powerLevel = :powerLevel WHERE serial = :serial")
    int updatePowerLevelBySerial(@Param("serial") String serial, @Param("powerLevel") double powerLevel);
}
