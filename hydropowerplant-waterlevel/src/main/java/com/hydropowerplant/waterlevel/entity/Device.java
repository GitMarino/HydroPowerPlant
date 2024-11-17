package com.hydropowerplant.waterlevel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;


@Entity
@Table(name = Device.TABLE_NAME)
public class Device {

    public static final String TABLE_NAME = "device";

    @Id
    @Column(name = "serial", length = 50)
    private String serial;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "powerlevel", nullable = false)
    private double powerLevel;

    public Device(String serial, String name, double powerLevel) {
        this.serial = serial;
        this.name = name;
        this.powerLevel = powerLevel;
    }

    public String getSerial() {
        return serial;
    }

    public String getName() {
        return name;
    }

    public double getPowerLevel() {
        return powerLevel;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerLevel(double powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device device)) return false;
        return Double.compare(powerLevel, device.powerLevel) == 0 && Objects.equals(serial, device.serial) && Objects.equals(name, device.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial, name, powerLevel);
    }

    @Override
    public String toString() {
        return "Device{" +
                "serial='" + serial + '\'' +
                ", name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}
