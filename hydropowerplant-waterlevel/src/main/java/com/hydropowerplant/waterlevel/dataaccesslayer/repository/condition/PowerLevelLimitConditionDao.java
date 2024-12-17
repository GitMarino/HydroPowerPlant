package com.hydropowerplant.waterlevel.dataaccesslayer.repository.condition;

import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PowerLevelLimitConditionDao extends JpaRepository<PowerLevelLimitCondition, Integer> {

    Set<PowerLevelLimitCondition> findByDevicesSerialAndMinPowerLevelGreaterThanOrMaxPowerLevelLessThan(String serial, double minPowerLevel, double maxPowerLevel);

}
