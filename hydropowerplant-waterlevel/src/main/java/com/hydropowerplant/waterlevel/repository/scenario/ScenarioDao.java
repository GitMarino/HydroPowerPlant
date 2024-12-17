package com.hydropowerplant.waterlevel.repository.scenario;

import com.hydropowerplant.waterlevel.entity.Scenario;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ScenarioDao extends JpaRepository<Scenario, Integer> {

    List<ScenarioProjection> findByEnabledTrueAndConditionsIn(Set<Condition> conditions);

}
