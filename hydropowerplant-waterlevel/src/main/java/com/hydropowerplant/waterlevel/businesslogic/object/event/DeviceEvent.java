package com.hydropowerplant.waterlevel.businesslogic.object.event;

import java.util.Objects;

public class DeviceEvent extends Event {

    private Double powerLevel;

    private String serial;

    public DeviceEvent(String recordedAt, Double powerLevel, String serial) {
        super(recordedAt);
        this.powerLevel = powerLevel;
        this.serial = serial;
    }

    public Double getPowerLevel() {
        return powerLevel;
    }

    public String getSerial() {
        return serial;
    }

    public void setPowerLevel(Double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DeviceEvent that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(powerLevel, that.powerLevel) && Objects.equals(serial, that.serial);
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
