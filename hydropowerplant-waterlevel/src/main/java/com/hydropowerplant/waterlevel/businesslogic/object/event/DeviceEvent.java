package com.hydropowerplant.waterlevel.businesslogic.object.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class DeviceEvent extends Event implements Serializable {

    @Serial
    private static final long serialVersionUID = -80280890421781227L;

    private Double powerLevel;

    private String recordedAt;

    private String serial;

    @NotNull
    public Double getPowerLevel() {
        return powerLevel;
    }

    @NotBlank
    public String getRecordedAt() {
        return recordedAt;
    }

    @NotBlank
    public String getSerial() {
        return serial;
    }

    public void setPowerLevel(Double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setRecordedAt(String recordedAt) {
        this.recordedAt = recordedAt;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public DeviceEvent(Double powerLevel, String recordedAt, String serial) {
        this.powerLevel = powerLevel;
        this.recordedAt = recordedAt;
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DeviceEvent that)) return false;
        return Objects.equals(powerLevel, that.powerLevel) && Objects.equals(recordedAt, that.recordedAt) && Objects.equals(serial, that.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerLevel, recordedAt, serial);
    }

    @Override
    public String toString() {
        return "DeviceEvent{" +
                "powerLevel=" + powerLevel +
                ", recordedAt='" + recordedAt + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
