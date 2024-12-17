package com.hydropowerplant.waterlevel.presentationlayer.dto.action;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PowerLevelActionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5423881021420343844L;

    @NotEmpty
    private List<@NotBlank String> devices;

    @NotNull
    private Double multiplier;

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    public List<String> getDevices() {
        return devices;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public String getName() {
        return name;
    }

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PowerLevelActionDto that)) return false;
        return Objects.equals(devices, that.devices) && Objects.equals(multiplier, that.multiplier) && Objects.equals(name, that.name) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(devices, multiplier, name, type);
    }

    @Override
    public String toString() {
        return "PowerLevelActionDto{" +
                "devices=" + devices +
                ", multiplier=" + multiplier +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    
}
