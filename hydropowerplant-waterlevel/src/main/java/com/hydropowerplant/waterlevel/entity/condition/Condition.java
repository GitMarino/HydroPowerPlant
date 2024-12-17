package com.hydropowerplant.waterlevel.entity.condition;

import com.hydropowerplant.waterlevel.entity.IdentifiedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.Objects;

@Entity(name = Condition.TABLE_NAME)
@Inheritance(strategy = InheritanceType.JOINED)
public class Condition extends IdentifiedEntity {

    public static final String TABLE_NAME = "condition";

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    public Condition() {
    }

    public Condition(Integer id, String name, String type) {
        super(id);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Condition condition)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(name, condition.name) && Objects.equals(type, condition.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, type);
    }

    @Override
    public String toString() {
        return "Condition{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    
}
