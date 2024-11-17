package com.hydropowerplant.waterlevel.ws.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class DeviceLogDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -841289762445079666L;

    private String serial;

    private Double powerLevel;

    private String recordedAt;

    public String getSerial() {
        return serial;
    }

    public Double getPowerLevel() {
        return powerLevel;
    }

    public String getRecordedAt() {
        return recordedAt;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setPowerLevel(Double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setRecordedAt(String recordedAt) {
        this.recordedAt = recordedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceLogDto that)) return false;
        return Objects.equals(serial, that.serial) && Objects.equals(powerLevel, that.powerLevel) && Objects.equals(recordedAt, that.recordedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial, powerLevel, recordedAt);
    }

    @Override
    public String toString() {
        return "DeviceLogDto{" +
                "serial='" + serial + '\'' +
                ", powerLevel=" + powerLevel +
                ", recordedAt='" + recordedAt + '\'' +
                '}';
    }
}
