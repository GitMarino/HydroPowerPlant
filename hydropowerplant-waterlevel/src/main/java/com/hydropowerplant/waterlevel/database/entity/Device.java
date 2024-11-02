package com.hydropowerplant.waterlevel.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = Device.TABLE_NAME)
public class Device {

    public static final String TABLE_NAME = "device";

    @Id
    @Column(name = "serial", length = 50)
    private String serial;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "powerlevel", nullable = false)
    private Integer powerLevel;

    public String getSerial() {
        return serial;
    }

    public String getName() {
        return name;
    }

    public Integer getPowerLevel() {
        return powerLevel;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerLevel(Integer powerLevel) {
        this.powerLevel = powerLevel;
    }
}
