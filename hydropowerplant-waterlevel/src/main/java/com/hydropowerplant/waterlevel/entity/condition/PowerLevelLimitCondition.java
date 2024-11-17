package com.hydropowerplant.waterlevel.entity.condition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = PowerLevelLimitCondition.TABLE_NAME)
public class PowerLevelLimitCondition {

    public static final String TABLE_NAME = "power_level_limit_condition";

    @Id
    @Column(name = "condition_id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @Column(name = "maxpowerlevel", nullable = false)
    private double maxPowerLevel;

    @Column(name = "minpowerlevel", nullable = false)
    private double minPowerLevel;

    public Integer getId() {
        return id;
    }

    public double getMaxPowerLevel() {
        return maxPowerLevel;
    }

    public double getMinPowerLevel() {
        return minPowerLevel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaxPowerLevel(double maxPowerLevel) {
        this.maxPowerLevel = maxPowerLevel;
    }

    public void setMinPowerLevel(double minPowerLevel) {
        this.minPowerLevel = minPowerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerLevelLimitCondition that)) return false;
        return Double.compare(maxPowerLevel, that.maxPowerLevel) == 0 && Double.compare(minPowerLevel, that.minPowerLevel) == 0 && Objects.equals(id, that.id) && Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, condition, maxPowerLevel, minPowerLevel);
    }

    @Override
    public String toString() {
        return "PowerLevelLimitCondition{" +
                "id=" + id +
                ", condition=" + condition +
                ", maxPowerLevel=" + maxPowerLevel +
                ", minPowerLevel=" + minPowerLevel +
                '}';
    }
}

