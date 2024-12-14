package com.hydropowerplant.waterlevel.repository.condition;

import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerLevelLimitConditionDao extends JpaRepository<PowerLevelLimitCondition, Integer> {
}
