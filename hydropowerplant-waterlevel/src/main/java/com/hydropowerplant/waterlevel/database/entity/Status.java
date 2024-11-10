package com.hydropowerplant.waterlevel.database.entity;

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
@Table(name = Status.TABLE_NAME)
public class Status {

    public static final String TABLE_NAME = "status";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Device device;

    @Column(name = "powerlevel", nullable = false)
    private Integer powerLevel;

    @Column(name = "recordedat", nullable = false)
    private LocalDateTime recordedAt;

    public Status(Device device, Integer powerLevel, LocalDateTime recordedAt) {
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

    public Integer getPowerLevel() {
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

    public void setPowerLevel(Integer powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status status)) return false;
        return Objects.equals(id, status.id) && Objects.equals(device, status.device) && Objects.equals(powerLevel, status.powerLevel) && Objects.equals(recordedAt, status.recordedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, device, powerLevel, recordedAt);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", device=" + device +
                ", powerLevel=" + powerLevel +
                ", recordedAt=" + recordedAt +
                '}';
    }
}
