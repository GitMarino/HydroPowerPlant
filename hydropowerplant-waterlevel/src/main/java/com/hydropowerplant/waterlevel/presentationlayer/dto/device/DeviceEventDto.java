package com.hydropowerplant.waterlevel.presentationlayer.dto.device;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class DeviceEventDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8893632167406455616L;

    @NotNull
    private Double powerLevel;

    @NotBlank
    private String recordedAt;

    @NotBlank
    private String serial;

    public Double getPowerLevel() {
        return powerLevel;
    }

    public String getRecordedAt() {
        return recordedAt;
    }

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DeviceEventDto that)) return false;
        return Objects.equals(powerLevel, that.powerLevel) && Objects.equals(recordedAt, that.recordedAt) && Objects.equals(serial, that.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerLevel, recordedAt, serial);
    }

    @Override
    public String toString() {
        return "DeviceEventDto{" +
                "powerLevel=" + powerLevel +
                ", recordedAt='" + recordedAt + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
    
}
