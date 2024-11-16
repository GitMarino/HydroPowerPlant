package com.hydropowerplant.waterlevel.entity.relationship;


import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelActionRelationshipKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = DevicePowerLevelActionRelationship.TABLE_NAME)
public class DevicePowerLevelActionRelationship {

    public static final String TABLE_NAME = "device_power_level_action";

    @EmbeddedId
    DevicePowerLevelActionRelationshipKey id;

    public DevicePowerLevelActionRelationshipKey getId() {
        return id;
    }

    public void setId(DevicePowerLevelActionRelationshipKey id) {
        this.id = id;
    }
}
