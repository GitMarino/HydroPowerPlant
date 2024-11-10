package com.hydropowerplant.waterlevel.repository;

import com.hydropowerplant.waterlevel.database.entity.condition.PowerLevelCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerLevelConditionDao extends JpaRepository<PowerLevelCondition, Integer> {

    @Query("SELECT c.id "
            + "FROM PowerLevelLimitCondition c "
            + "join DevicePowerLevelConditionRelationship dc on c.id=dc.id.powerLevelCondition.id "
            + "WHERE dc.id.device.serial=?1")
    List<Integer> findPowerLevelConditionIdsByDevice(String deviceSerial);
}
