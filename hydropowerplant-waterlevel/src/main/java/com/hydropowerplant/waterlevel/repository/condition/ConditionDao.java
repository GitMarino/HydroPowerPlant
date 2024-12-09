package com.hydropowerplant.waterlevel.repository.condition;

import com.hydropowerplant.waterlevel.entity.condition.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionDao extends JpaRepository<Condition, Integer> {
}
