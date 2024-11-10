package com.hydropowerplant.waterlevel.repository;

import com.hydropowerplant.waterlevel.database.entity.condition.PowerLevelLimitCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerLevelLimitConditionDao extends JpaRepository<PowerLevelLimitCondition, Integer> {

    @Query("SELECT c "
            + "FROM PowerLevelLimitCondition c "
            + "join DevicePowerLevelLimitConditionRelationship dc on c.id=dc.id.powerLevelLimitCondition.id "
            + "WHERE dc.id.device.serial=?1")
    List<PowerLevelLimitCondition> findAllByDevice(String deviceSerial);

}
