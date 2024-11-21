package com.hydropowerplant.waterlevel.entity.condition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = PowerLevelLimitCondition.TABLE_NAME)
public class PowerLevelLimitCondition extends Condition {

    public static final String TABLE_NAME = "power_level_limit_condition";

    @Column(name = "maxpowerlevel", nullable = false)
    private double maxPowerLevel;

    @Column(name = "minpowerlevel", nullable = false)
    private double minPowerLevel;

    public double getMaxPowerLevel() {
        return maxPowerLevel;
    }

    public double getMinPowerLevel() {
        return minPowerLevel;
    }

    public void setMaxPowerLevel(double maxPowerLevel) {
        this.maxPowerLevel = maxPowerLevel;
    }

    public void setMinPowerLevel(double minPowerLevel) {
        this.minPowerLevel = minPowerLevel;
    }

}

