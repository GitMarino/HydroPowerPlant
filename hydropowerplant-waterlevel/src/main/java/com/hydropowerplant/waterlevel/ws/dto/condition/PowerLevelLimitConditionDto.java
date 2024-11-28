package com.hydropowerplant.waterlevel.ws.dto.condition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

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
}
