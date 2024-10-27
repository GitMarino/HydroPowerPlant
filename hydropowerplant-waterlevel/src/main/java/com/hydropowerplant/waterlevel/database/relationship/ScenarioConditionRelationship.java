package com.hydropowerplant.waterlevel.database.relationship;

import com.hydropowerplant.waterlevel.database.key.ScenarioConditionRelationshipKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = ScenarioConditionRelationship.TABLE_NAME)
public class ScenarioConditionRelationship {

    public static final String TABLE_NAME = "scenario_condition";

    @EmbeddedId
    ScenarioConditionRelationshipKey id;

    public ScenarioConditionRelationshipKey getId() {
        return id;
    }

    public void setId(ScenarioConditionRelationshipKey id) {
        this.id = id;
    }
}
