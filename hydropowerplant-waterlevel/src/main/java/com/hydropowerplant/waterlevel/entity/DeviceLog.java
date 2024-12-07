package com.hydropowerplant.waterlevel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = DeviceLog.TABLE_NAME)
public class DeviceLog {

    public static final String TABLE_NAME = "device_log";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Device device;

    @Column(name = "powerlevel", nullable = false)
    private double powerLevel;

    @Column(name = "recordedat", nullable = false)
    private LocalDateTime recordedAt;

    public DeviceLog(Integer id, Device device, double powerLevel, LocalDateTime recordedAt) {
        this.id = id;
        this.device = device;
        this.powerLevel = powerLevel;
        this.recordedAt = recordedAt;
    }

    public Integer getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public double getPowerLevel() {
        return powerLevel;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setPowerLevel(double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceLog deviceLog)) return false;
        return Double.compare(powerLevel, deviceLog.powerLevel) == 0 && Objects.equals(id, deviceLog.id) && Objects.equals(device, deviceLog.device) && Objects.equals(recordedAt, deviceLog.recordedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, device, powerLevel, recordedAt);
    }

    @Override
    public String toString() {
        return "DeviceLog{" +
                "id=" + id +
                ", device=" + device +
                ", powerLevel=" + powerLevel +
                ", recordedAt=" + recordedAt +
                '}';
    }
}
