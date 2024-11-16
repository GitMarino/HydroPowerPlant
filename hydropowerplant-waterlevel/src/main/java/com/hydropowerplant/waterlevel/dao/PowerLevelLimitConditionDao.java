package com.hydropowerplant.waterlevel.dao;

import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerLevelLimitConditionDao extends JpaRepository<PowerLevelLimitCondition, Integer> {

    @Query("SELECT c.id "
            + "FROM PowerLevelLimitCondition c "
            + "join DevicePowerLevelLimitConditionRelationship dc on c.id=dc.id.powerLevelLimitCondition.id "
            + "WHERE dc.id.device.serial=?1 and (?2<c.minPowerLevel or c.maxPowerLevel>?2)")
    List<Integer> findByDeviceSerialAndPowerLevel(String deviceSerial, int devicePowerLevel);

}
