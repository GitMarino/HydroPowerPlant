package com.hydropowerplant.waterlevel.entity.relationship.key;


import com.hydropowerplant.waterlevel.entity.Device;
import com.hydropowerplant.waterlevel.entity.action.PowerLevelAction;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class DevicePowerLevelActionRelationshipKey {

    @ManyToOne
    @JoinColumn(name = "device_serial", nullable = false)
    Device device;

    @ManyToOne
    @JoinColumn(name = "powerlevelaction_id", nullable = false)
    PowerLevelAction powerLevelAction;

    public DevicePowerLevelActionRelationshipKey(Device device, PowerLevelAction powerLevelAction) {
        this.device = device;
        this.powerLevelAction = powerLevelAction;
    }

    public Device getDevice() {
        return device;
    }

    public PowerLevelAction getPowerLevelAction() {
        return powerLevelAction;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setPowerLevelAction(PowerLevelAction powerLevelAction) {
        this.powerLevelAction = powerLevelAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DevicePowerLevelActionRelationshipKey that)) return false;
        return Objects.equals(device, that.device) && Objects.equals(powerLevelAction, that.powerLevelAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(device, powerLevelAction);
    }

    @Override
    public String toString() {
        return "DevicePowerLevelActionRelationshipKey{" +
                "device=" + device +
                ", powerLevelAction=" + powerLevelAction +
                '}';
    }
}
