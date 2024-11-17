package com.hydropowerplant.waterlevel.dao.scenario;

import com.hydropowerplant.waterlevel.entity.relationship.ScenarioConditionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.ScenarioConditionRelationshipKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioConditionRelationshipDao extends JpaRepository<ScenarioConditionRelationship, ScenarioConditionRelationshipKey> {
}
