package com.hydropowerplant.waterlevel.entity.relationship.key;

import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.condition.PowerLevelLimitCondition;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class DevicePowerLevelLimitConditionRelationshipKey {

    @ManyToOne
    @JoinColumn(name = "device_serial", nullable = false)
    Device device;

    @ManyToOne
    @JoinColumn(name = "powerlevellimitcondition_id", nullable = false)
    PowerLevelLimitCondition powerLevelLimitCondition;

    public Device getDevice() {
        return device;
    }

    public PowerLevelLimitCondition getPowerLevelLimitCondition() {
        return powerLevelLimitCondition;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setPowerLevelLimitCondition(PowerLevelLimitCondition powerLevelLimitCondition) {
        this.powerLevelLimitCondition = powerLevelLimitCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DevicePowerLevelLimitConditionRelationshipKey that)) return false;
        return Objects.equals(device, that.device) && Objects.equals(powerLevelLimitCondition, that.powerLevelLimitCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(device, powerLevelLimitCondition);
    }

    @Override
    public String toString() {
        return "DevicePowerLevelLimitConditionRelationshipKey{" +
                "device=" + device +
                ", powerLevelLimitCondition=" + powerLevelLimitCondition +
                '}';
    }
}
