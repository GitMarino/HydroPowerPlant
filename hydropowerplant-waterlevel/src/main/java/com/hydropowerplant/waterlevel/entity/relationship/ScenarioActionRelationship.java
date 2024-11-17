package com.hydropowerplant.waterlevel.entity.relationship;

import com.hydropowerplant.waterlevel.entity.relationship.key.ScenarioActionRelationshipKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = ScenarioActionRelationship.TABLE_NAME)
public class ScenarioActionRelationship {

    public static final String TABLE_NAME = "scenario_action";

    @EmbeddedId
    ScenarioActionRelationshipKey id;

    public ScenarioActionRelationship(ScenarioActionRelationshipKey id) {
        this.id = id;
    }

    public ScenarioActionRelationshipKey getId() {
        return id;
    }

    public void setId(ScenarioActionRelationshipKey id) {
        this.id = id;
    }
}
