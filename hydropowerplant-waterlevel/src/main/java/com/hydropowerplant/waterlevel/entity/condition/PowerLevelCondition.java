package com.hydropowerplant.waterlevel.entity.condition;

import com.hydropowerplant.waterlevel.entity.device.Device;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Objects;
import java.util.Set;

@Entity(name = PowerLevelCondition.TABLE_NAME)
public class PowerLevelCondition extends Condition {

    public static final String TABLE_NAME = "power_level_condition";

    @ManyToMany
    private Set<Device> devices;

    public PowerLevelCondition() {
    }

    public PowerLevelCondition(Integer id, String name, String type, Set<Device> devices) {
        super(id, name, type);
        this.devices = devices;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PowerLevelCondition that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(devices, that.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), devices);
    }

    @Override
    public String toString() {
        return "PowerLevelCondition{" +
                "devices=" + devices +
                '}';
    }
    
}
