package com.hydropowerplant.waterlevel.businesslogic.object.event;

import java.util.Objects;

public class DeviceEvent extends Event {

    private double powerLevel;

    private String serial;

    public DeviceEvent(String recordedAt, double powerLevel, String serial) {
        super(recordedAt);
        this.powerLevel = powerLevel;
        this.serial = serial;
    }

    public double getPowerLevel() {
        return powerLevel;
    }

    public String getSerial() {
        return serial;
    }

    public void setPowerLevel(double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DeviceEvent that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(powerLevel, that.powerLevel) == 0 && Objects.equals(serial, that.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), powerLevel, serial);
    }

    @Override
    public String toString() {
        return "DeviceEvent{" +
                "powerLevel=" + powerLevel +
                ", serial='" + serial + '\'' +
                '}';
    }
}
