package com.hydropowerplant.waterlevel.database.relationship;

import com.hydropowerplant.waterlevel.database.key.DevicePowerLevelConditionRelationshipKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = DevicePowerLevelConditionRelationship.TABLE_NAME)
public class DevicePowerLevelConditionRelationship {

    public static final String TABLE_NAME = "device_power_level_condition";

    @EmbeddedId
    DevicePowerLevelConditionRelationshipKey id;

    public DevicePowerLevelConditionRelationshipKey getId() {
        return id;
    }

    public void setId(DevicePowerLevelConditionRelationshipKey id) {
        this.id = id;
    }
}
