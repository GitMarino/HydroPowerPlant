package com.hydropowerplant.waterlevel.entity.action;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = PowerLevelAction.TABLE_NAME)
public class PowerLevelAction extends Action {

    public static final String TABLE_NAME = "power_level_action";

    @Column(name = "multiplier", nullable = false)
    private String multiplier;

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }
}
