package com.hydropowerplant.waterlevel.repository.action;

import com.hydropowerplant.waterlevel.entity.action.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionDao extends JpaRepository<Action, Integer> {

    List<Action> findByScenarioEnabledTrueAndScenarioConditionRelationshipIdConditionIdIn(List<Integer> conditionsIds);

}
