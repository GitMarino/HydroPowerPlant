package com.hydropowerplant.waterlevel.database.relationship;

import com.hydropowerplant.waterlevel.database.key.DevicePowerLevelLimitConditionRelationshipKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = DevicePowerLevelLimitConditionRelationship.TABLE_NAME)
public class DevicePowerLevelLimitConditionRelationship {

    public static final String TABLE_NAME = "device_power_level_limit_condition";

    @EmbeddedId
    DevicePowerLevelLimitConditionRelationshipKey id;

    public DevicePowerLevelLimitConditionRelationshipKey getId() {
        return id;
    }

    public void setId(DevicePowerLevelLimitConditionRelationshipKey id) {
        this.id = id;
    }
}
