package com.hydropowerplant.waterlevel.database.key;

import com.hydropowerplant.waterlevel.database.entity.Device;
import com.hydropowerplant.waterlevel.database.entity.condition.PowerLevelCondition;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class DevicePowerLevelConditionRelationshipKey {

    @ManyToOne
    @JoinColumn(name = "device_serial", nullable = false)
    Device device;

    @ManyToOne
    @JoinColumn(name = "powerlevelcondition_id", nullable = false)
    PowerLevelCondition powerLevelCondition;

    public Device getDevice() {
        return device;
    }

    public PowerLevelCondition getPowerLevelCondition() {
        return powerLevelCondition;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setPowerLevelCondition(PowerLevelCondition powerLevelCondition) {
        this.powerLevelCondition = powerLevelCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DevicePowerLevelConditionRelationshipKey that)) return false;
        return Objects.equals(device, that.device) && Objects.equals(powerLevelCondition, that.powerLevelCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(device, powerLevelCondition);
    }

    @Override
    public String toString() {
        return "DevicePowerLevelConditionRelationshipKey{" +
                "device=" + device +
                ", powerLevelCondition=" + powerLevelCondition +
                '}';
    }
}
