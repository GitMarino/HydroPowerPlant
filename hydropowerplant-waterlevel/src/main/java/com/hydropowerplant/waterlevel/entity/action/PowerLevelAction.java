package com.hydropowerplant.waterlevel.entity.action;

import com.hydropowerplant.waterlevel.entity.device.Device;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Objects;
import java.util.Set;

@Entity(name = PowerLevelAction.TABLE_NAME)
public class PowerLevelAction extends Action {

    public static final String TABLE_NAME = "power_level_action";

    @ManyToMany
    private Set<Device> devices;

    @Column(name = "multiplier", nullable = false)
    private double multiplier;

    public PowerLevelAction() {
    }

    public PowerLevelAction(Integer id, String name, String type, Set<Device> devices, double multiplier) {
        super(id, name, type);
        this.devices = devices;
        this.multiplier = multiplier;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PowerLevelAction that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(multiplier, that.multiplier) == 0 && Objects.equals(devices, that.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), devices, multiplier);
    }

    @Override
    public String toString() {
        return "PowerLevelAction{" +
                "devices=" + devices +
                ", multiplier=" + multiplier +
                '}';
    }
}
