package com.hydropowerplant.waterlevel.ws.dto.device;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class DeviceDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4583358869346738599L;

    private String serial;

    private String name;

    private Double powerLevel;

    @NotBlank
    public String getSerial() {
        return serial;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    @NotNull
    public Double getPowerLevel() {
        return powerLevel;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setPowerLevel(Double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceDto deviceDto)) return false;
        return Objects.equals(serial, deviceDto.serial) && Objects.equals(name, deviceDto.name) && Objects.equals(powerLevel, deviceDto.powerLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial, name, powerLevel);
    }

    @Override
    public String toString() {
        return "DeviceDto{" +
                "serial='" + serial + '\'' +
                ", name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}
