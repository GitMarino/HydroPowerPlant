package com.hydropowerplant.waterlevel.entity.action;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = PowerLevelAction.TABLE_NAME)
public class PowerLevelAction extends Action {

    public static final String TABLE_NAME = "power_level_action";

    @Column(name = "multiplier", nullable = false)
    private double multiplier;

    public PowerLevelAction(Integer id, String name, String type, double multiplier) {
        super(id, name, type);
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
