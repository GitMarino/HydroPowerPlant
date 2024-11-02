package com.hydropowerplant.waterlevel.database.entity.condition;

import com.hydropowerplant.waterlevel.database.entity.Device;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = DeviceExtremeCondition.TABLE_NAME)
public class DeviceExtremeCondition {

    public static final String TABLE_NAME = "device_extreme_condition";

    @Id
    @Column(name = "condition_id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @OneToOne
    private Device device;

    @Column(name = "maxpowerlevel", nullable = false)
    private Integer maxPowerLevel;

    @Column(name = "minpowerlevel", nullable = false)
    private Integer minPowerLevel;

    public Integer getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public Integer getMaxPowerLevel() {
        return maxPowerLevel;
    }

    public Integer getMinPowerLevel() {
        return minPowerLevel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setMaxPowerLevel(Integer maxPowerLevel) {
        this.maxPowerLevel = maxPowerLevel;
    }

    public void setMinPowerLevel(Integer minPowerLevel) {
        this.minPowerLevel = minPowerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceExtremeCondition that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(condition, that.condition) && Objects.equals(device, that.device) && Objects.equals(maxPowerLevel, that.maxPowerLevel) && Objects.equals(minPowerLevel, that.minPowerLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, condition, device, maxPowerLevel, minPowerLevel);
    }

    @Override
    public String toString() {
        return "DeviceExtremeCondition{" +
                "id=" + id +
                ", condition=" + condition +
                ", device=" + device +
                ", maxPowerLevel=" + maxPowerLevel +
                ", minPowerLevel=" + minPowerLevel +
                '}';
    }
}

