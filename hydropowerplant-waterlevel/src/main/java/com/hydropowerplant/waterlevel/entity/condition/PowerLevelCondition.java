package com.hydropowerplant.waterlevel.entity.condition;

import jakarta.persistence.Entity;

@Entity(name = PowerLevelCondition.TABLE_NAME)
public class PowerLevelCondition extends Condition {

    public static final String TABLE_NAME = "power_level_condition";

}
