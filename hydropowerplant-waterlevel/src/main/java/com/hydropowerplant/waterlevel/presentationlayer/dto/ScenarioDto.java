package com.hydropowerplant.waterlevel.presentationlayer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ScenarioDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148276754147704024L;

    @NotEmpty
    private List<@NotNull Integer> actions;

    @NotEmpty
    private List<@NotNull Integer> conditions;

    private String description;

    @NotNull
    private Boolean enabled;

    @NotBlank
    private String name;

    public List<Integer> getActions() {
        return actions;
    }

    public List<Integer> getConditions() {
        return conditions;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public void setActions(List<Integer> actions) {
        this.actions = actions;
    }

    public void setConditions(List<Integer> conditions) {
        this.conditions = conditions;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScenarioDto that)) return false;
        return Objects.equals(actions, that.actions) && Objects.equals(conditions, that.conditions) && Objects.equals(description, that.description) && Objects.equals(enabled, that.enabled) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actions, conditions, description, enabled, name);
    }

    @Override
    public String toString() {
        return "ScenarioDto{" +
                "actions=" + actions +
                ", conditions=" + conditions +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", name='" + name + '\'' +
                '}';
    }
    
}
