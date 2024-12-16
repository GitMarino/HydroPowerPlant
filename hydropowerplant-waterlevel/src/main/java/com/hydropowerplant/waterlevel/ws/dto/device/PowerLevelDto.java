package com.hydropowerplant.waterlevel.ws.dto.device;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class PowerLevelDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 7861821225655031488L;

    @NotNull
    private Double powerLevel;

    public PowerLevelDto(Double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public Double getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(Double powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PowerLevelDto that)) return false;
        return Objects.equals(powerLevel, that.powerLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(powerLevel);
    }

    @Override
    public String toString() {
        return "PowerLevelDto{" +
                "powerLevel=" + powerLevel +
                '}';
    }
}
