package com.hydropowerplant.waterlevel.entity;

import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = Scenario.TABLE_NAME)
public class Scenario extends IdentifiedEntity {

    public static final String TABLE_NAME = "scenario";

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "scenario_id")
    private Set<Action> actions;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "scenario_id")
    private Set<Condition> conditions;

    @Column(name = "description")
    private String description;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "name", nullable = false)
    private String name;

    public Scenario() {
    }

    public Scenario(Integer id, String description, Set<Action> actions, Set<Condition> conditions, boolean enabled, String name) {
        super(id);
        this.actions = actions;
        this.conditions = conditions;
        this.description = description;
        this.enabled = enabled;
        this.name = name;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public Set<Condition> getConditions() {
        return conditions;
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

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    public void setConditions(Set<Condition> conditions) {
        this.conditions = conditions;
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
        if (!(o instanceof Scenario scenario)) return false;
        if (!super.equals(o)) return false;
        return enabled == scenario.enabled && Objects.equals(actions, scenario.actions) && Objects.equals(conditions, scenario.conditions) && Objects.equals(description, scenario.description) && Objects.equals(name, scenario.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), actions, conditions, description, enabled, name);
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "actions=" + actions +
                ", conditions=" + conditions +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", name='" + name + '\'' +
                '}';
    }
}
