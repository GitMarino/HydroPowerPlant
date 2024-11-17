package com.hydropowerplant.waterlevel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = Scenario.TABLE_NAME)
public class Scenario {

    public static final String TABLE_NAME = "scenario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "name", nullable = false)
    private String name;

    public Scenario(Integer id, String description, boolean enabled, String name) {
        this.id = id;
        this.description = description;
        this.enabled = enabled;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scenario scenario)) return false;
        return enabled == scenario.enabled && Objects.equals(id, scenario.id) && Objects.equals(description, scenario.description) && Objects.equals(name, scenario.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, enabled, name);
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", name='" + name + '\'' +
                '}';
    }
}
