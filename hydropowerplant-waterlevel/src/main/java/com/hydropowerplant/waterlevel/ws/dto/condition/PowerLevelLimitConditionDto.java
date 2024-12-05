package com.hydropowerplant.waterlevel.ws.dto.condition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PowerLevelLimitConditionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6407212529034798218L;

    private List<String> devices;

    private Double maxPowerLevel;

    private Double minPowerLevel;

    private String name;

    private String type;

    @NotEmpty
    public List<String> getDevices() {
        return devices;
    }

    @NotNull
    public Double getMaxPowerLevel() {
        return maxPowerLevel;
    }

    @NotNull
    public Double getMinPowerLevel() {
        return minPowerLevel;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    @NotBlank
    public String getType() {
        return type;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    public void setMaxPowerLevel(Double maxPowerLevel) {
        this.maxPowerLevel = maxPowerLevel;
    }

    public void setMinPowerLevel(Double minPowerLevel) {
        this.minPowerLevel = minPowerLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PowerLevelLimitConditionDto that)) return false;
        return Objects.equals(devices, that.devices) && Objects.equals(maxPowerLevel, that.maxPowerLevel) && Objects.equals(minPowerLevel, that.minPowerLevel) && Objects.equals(name, that.name) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(devices, maxPowerLevel, minPowerLevel, name, type);
    }

    @Override
    public String toString() {
        return "PowerLevelLimitConditionDto{" +
                "devices=" + devices +
                ", maxPowerLevel=" + maxPowerLevel +
                ", minPowerLevel=" + minPowerLevel +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
