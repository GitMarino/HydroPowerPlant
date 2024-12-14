package com.hydropowerplant.waterlevel.repository.condition;

import com.hydropowerplant.waterlevel.entity.condition.PowerLevelCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerLevelConditionDao extends JpaRepository<PowerLevelCondition, Integer> {
}
