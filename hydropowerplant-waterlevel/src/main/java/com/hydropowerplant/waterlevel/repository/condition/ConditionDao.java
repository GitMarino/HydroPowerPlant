package com.hydropowerplant.waterlevel.repository.condition;

import com.hydropowerplant.waterlevel.entity.condition.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionDao extends JpaRepository<Condition, Integer> {

    @Query(value = "SELECT c.id " +
            "FROM condition c " +
            "JOIN power_level_condition plc on c.id=plc.id " +
            "JOIN power_level_condition_devices cd on c.id=cd.power_vel_condition_id " +
            "WHERE cd.devices_serial=?1",
            nativeQuery = true)
    List<Integer> findPowerLevelConditionByDevice(String deviceSerial);

    @Query(value = "SELECT c.id " +
            "FROM condition c " +
            "JOIN power_level_limit_condition plc on c.id=plc.id " +
            "JOIN power_level_limit_condition_devices cd on c.id=cd.power_level_limit_condition_id " +
            "WHERE cd.devices_serial=?1 and (?2<plc.minPowerLevel or plc.maxPowerLevel>?2)",
            nativeQuery = true)
    List<Integer> findPowerLevelLimitConditionByDeviceAndPowerLevel(String deviceSerial, double devicePowerLevel);

}
