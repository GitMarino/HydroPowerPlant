package com.hydropowerplant.waterlevel.dao;

import com.hydropowerplant.waterlevel.database.entity.condition.PowerLevelLimitCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerLevelLimitConditionRepository extends JpaRepository<PowerLevelLimitCondition, Integer> {

    @Query("SELECT c "
            + "FROM PowerLevelLimitCondition c "
            + "join DevicePowerLevelLimitConditionRelationship dc on c.id=dc.id.powerlevellimitcondition.id "
            + "WHERE dc.id.device.serial=?1")
    List<PowerLevelLimitCondition> findAllByDevice(String deviceSerial);

}
