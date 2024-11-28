package com.hydropowerplant.waterlevel.entity.relationship;

import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelConditionRelationshipKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = DevicePowerLevelConditionRelationship.TABLE_NAME)
public class DevicePowerLevelConditionRelationship {

    public static final String TABLE_NAME = "device_power_level_condition";

    @EmbeddedId
    DevicePowerLevelConditionRelationshipKey id;

    public DevicePowerLevelConditionRelationship(DevicePowerLevelConditionRelationshipKey id) {
        this.id = id;
    }

    public DevicePowerLevelConditionRelationshipKey getId() {
        return id;
    }

    public void setId(DevicePowerLevelConditionRelationshipKey id) {
        this.id = id;
    }
}
