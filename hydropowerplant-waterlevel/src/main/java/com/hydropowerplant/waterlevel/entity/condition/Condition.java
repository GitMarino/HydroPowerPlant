package com.hydropowerplant.waterlevel.entity.condition;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = Condition.TABLE_NAME)
public class Condition {

    public static final String TABLE_NAME = "condition";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToOne(mappedBy = "condition", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PowerLevelCondition powerLevelCondition;

    @OneToOne(mappedBy = "condition", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PowerLevelLimitCondition powerLevelLimitCondition;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Condition condition)) return false;
        return Objects.equals(id, condition.id) && Objects.equals(name, condition.name) && Objects.equals(type, condition.type) && Objects.equals(powerLevelCondition, condition.powerLevelCondition) && Objects.equals(powerLevelLimitCondition, condition.powerLevelLimitCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, powerLevelCondition, powerLevelLimitCondition);
    }

    @Override
    public String toString() {
        return "Condition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", powerLevelCondition=" + powerLevelCondition +
                ", powerLevelLimitCondition=" + powerLevelLimitCondition +
                '}';
    }
}
