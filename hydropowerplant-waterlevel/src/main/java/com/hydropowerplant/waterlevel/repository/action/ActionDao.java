package com.hydropowerplant.waterlevel.repository.action;

import com.hydropowerplant.waterlevel.entity.action.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActionDao extends JpaRepository<Action, Integer> {

    @Query(value = "SELECT c " +
            "FROM condition c " +
            "JOIN scenario s on c.scenario_id=s.id " +
            "JOIN action a on s.id=a.scenario_id " +
            "WHERE c.id in ?1 and s.enabled=true",
            nativeQuery = true)
    List<Action> findByScenarioEnabledTrueAndConditionIn(List<Integer> conditions);

}
