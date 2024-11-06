package com.hydropowerplant.waterlevel.database.entity.condition;

import com.hydropowerplant.waterlevel.database.entity.Device;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = PowerLevelCondition.TABLE_NAME)
public class PowerLevelCondition {

    public static final String TABLE_NAME = "power_level_condition";

    @Id
    @Column(name = "condition_id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @ManyToOne
    private Device device;

    @Column(name = "powerlevel", nullable = false)
    private Integer powerLevel;

    public Integer getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public Integer getPowerLevel() {
        return powerLevel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setPowerLevel(Integer powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerLevelCondition that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(condition, that.condition) && Objects.equals(device, that.device) && Objects.equals(powerLevel, that.powerLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, condition, device, powerLevel);
    }

    @Override
    public String toString() {
        return "PowerLevelCondition{" +
                "id=" + id +
                ", condition=" + condition +
                ", device=" + device +
                ", powerLevel=" + powerLevel +
                '}';
    }
}
