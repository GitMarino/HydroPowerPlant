package com.hydropowerplant.waterlevel.dao.relationship;

import com.hydropowerplant.waterlevel.entity.relationship.ScenarioActionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.ScenarioActionRelationshipKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioActionRelationshipDao extends JpaRepository<ScenarioActionRelationship, ScenarioActionRelationshipKey> {
}
