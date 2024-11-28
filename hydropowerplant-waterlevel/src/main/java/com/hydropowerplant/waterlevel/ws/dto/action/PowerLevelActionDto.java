package com.hydropowerplant.waterlevel.ws.dto.action;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class PowerLevelActionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5423881021420343844L;

    private List<String> devices;

    private Double multiplier;

    private String name;

    private String type;

    @NotEmpty
    public List<String> getDevices() {
        return devices;
    }

    @NotNull
    public Double getMultiplier() {
        return multiplier;
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

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
