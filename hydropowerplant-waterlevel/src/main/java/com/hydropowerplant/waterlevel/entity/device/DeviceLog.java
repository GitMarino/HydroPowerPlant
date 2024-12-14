package com.hydropowerplant.waterlevel.entity.device;

import com.hydropowerplant.waterlevel.entity.IdentifiedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = DeviceLog.TABLE_NAME)
public class DeviceLog extends IdentifiedEntity {

    public static final String TABLE_NAME = "device_log";

    @ManyToOne
    private Device device;

    @Column(name = "powerlevel", nullable = false)
    private double powerLevel;

    @Column(name = "recordedat", nullable = false)
    private LocalDateTime recordedAt;

    public DeviceLog(Integer id, Device device, double powerLevel, LocalDateTime recordedAt) {
        super(id);
        this.device = device;
        this.powerLevel = powerLevel;
        this.recordedAt = recordedAt;
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
        if (!(o instanceof DeviceLog deviceLog)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(powerLevel, deviceLog.powerLevel) == 0 && Objects.equals(device, deviceLog.device) && Objects.equals(recordedAt, deviceLog.recordedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), device, powerLevel, recordedAt);
    }

    @Override
    public String toString() {
        return "DeviceLog{" +
                "device=" + device +
                ", powerLevel=" + powerLevel +
                ", recordedAt=" + recordedAt +
                '}';
    }
}
