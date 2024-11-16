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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerLevelCondition that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, condition);
    }

    @Override
    public String toString() {
        return "PowerLevelCondition{" +
                "id=" + id +
                ", condition=" + condition +
                '}';
    }
}
