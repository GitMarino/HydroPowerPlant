package com.hydropowerplant.waterlevel.businesslogic.object.event;

public class DeviceEvent extends Event {

    private String serial;

    private double powerLevel;

    public String getSerial() {
        return serial;
    }

    public double getPowerLevel() {
        return powerLevel;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setPowerLevel(double powerLevel) {
        this.powerLevel = powerLevel;
    }
}
