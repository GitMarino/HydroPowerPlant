package com.hydropowerplant.waterlevel.repository.condition;

import com.hydropowerplant.waterlevel.entity.condition.Condition;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PowerLevelConditionDao extends JpaRepository<PowerLevelCondition, Integer> {

    Set<Condition> findByDevicesSerial(String serial);

}
