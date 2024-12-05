package com.hydropowerplant.waterlevel.ws.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class DeviceDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4583358869346738599L;

    private String name;

    private Double powerLevel;

    private String serial;

    @NotBlank
    public String getName() {
        return name;
    }

    @NotNull
    public Double getPowerLevel() {
        return powerLevel;
    }

    @NotBlank
    public String getSerial() {
        return serial;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerLevel(Double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DeviceDto deviceDto)) return false;
        return Objects.equals(name, deviceDto.name) && Objects.equals(powerLevel, deviceDto.powerLevel) && Objects.equals(serial, deviceDto.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, powerLevel, serial);
    }

    @Override
    public String toString() {
        return "DeviceDto{" +
                "name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                ", serial='" + serial + '\'' +
                '}';
    }
}
