package com.hydropowerplant.waterlevel.dao;

import com.hydropowerplant.waterlevel.entity.action.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionDao extends JpaRepository<Action, Integer> {

    @Query("SELECT a "
            + "FROM ScenarioConditionRelationship sc "
            + "join Scenario s on sc.id.scenario.id=s.id "
            + "join ScenarioActionRelationship sa on s.id=sa.id.scenario.id "
            + "join Action a on sa.id.action.id=a.id "
            + "WHERE s.enabled=true and sc.id.condition.id in ?1")
    List<Action> findByConditions(List<Integer> conditions);

    /*@Query("SELECT e FROM EntityName e WHERE e.columnName IN :ids")
    List<EntityName> findByColumnNameIn(@Param("ids") List<Integer> ids);*/
}
