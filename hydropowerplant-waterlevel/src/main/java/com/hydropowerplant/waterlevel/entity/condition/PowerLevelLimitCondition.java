package com.hydropowerplant.waterlevel.entity.condition;

import com.hydropowerplant.waterlevel.entity.device.Device;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Objects;
import java.util.Set;

@Entity(name = PowerLevelLimitCondition.TABLE_NAME)
public class PowerLevelLimitCondition extends Condition {

    public static final String TABLE_NAME = "power_level_limit_condition";

    @ManyToMany
    private Set<Device> devices;

    @Column(name = "maxpowerlevel", nullable = false)
    private double maxPowerLevel;

    @Column(name = "minpowerlevel", nullable = false)
    private double minPowerLevel;

    public PowerLevelLimitCondition() {
    }

    public PowerLevelLimitCondition(Integer id, String name, String type, Set<Device> devices, double maxPowerLevel, double minPowerLevel) {
        super(id, name, type);
        this.devices = devices;
        this.maxPowerLevel = maxPowerLevel;
        this.minPowerLevel = minPowerLevel;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public double getMaxPowerLevel() {
        return maxPowerLevel;
    }

    public double getMinPowerLevel() {
        return minPowerLevel;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public void setMaxPowerLevel(double maxPowerLevel) {
        this.maxPowerLevel = maxPowerLevel;
    }

    public void setMinPowerLevel(double minPowerLevel) {
        this.minPowerLevel = minPowerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PowerLevelLimitCondition that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(maxPowerLevel, that.maxPowerLevel) == 0 && Double.compare(minPowerLevel, that.minPowerLevel) == 0 && Objects.equals(devices, that.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), devices, maxPowerLevel, minPowerLevel);
    }

    @Override
    public String toString() {
        return "PowerLevelLimitCondition{" +
                "devices=" + devices +
                ", maxPowerLevel=" + maxPowerLevel +
                ", minPowerLevel=" + minPowerLevel +
                '}';
    }
    
}

