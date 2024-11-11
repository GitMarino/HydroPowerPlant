package com.hydropowerplant.waterlevel.repository;

import com.hydropowerplant.waterlevel.database.entity.condition.PowerLevelCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerLevelConditionDao extends JpaRepository<PowerLevelCondition, Integer> {

    @Query("SELECT id.powerLevelCondition.id "
            + "FROM DevicePowerLevelConditionRelationship "
            + "WHERE id.device.serial=?1")
    List<Integer> findAllByDevice(String deviceSerial);
}
