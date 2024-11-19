package com.hydropowerplant.waterlevel.ws.dto;

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

    private List<Integer> actionsIds;

    private List<Integer> conditionsIds;

    private String description;

    private Boolean enabled;

    private String name;

    @NotEmpty
    public List<Integer> getActionsIds() {
        return actionsIds;
    }

    @NotEmpty
    public List<Integer> getConditionsIds() {
        return conditionsIds;
    }

    public String getDescription() {
        return description;
    }

    @NotNull
    public Boolean getEnabled() {
        return enabled;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setActionsIds(List<Integer> actionsIds) {
        this.actionsIds = actionsIds;
    }

    public void setConditionsIds(List<Integer> conditionsIds) {
        this.conditionsIds = conditionsIds;
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
        return Objects.equals(actionsIds, that.actionsIds) && Objects.equals(conditionsIds, that.conditionsIds) && Objects.equals(description, that.description) && Objects.equals(enabled, that.enabled) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionsIds, conditionsIds, description, enabled, name);
    }

    @Override
    public String toString() {
        return "ScenarioDto{" +
                "actionsIds=" + actionsIds +
                ", conditionsIds=" + conditionsIds +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", name='" + name + '\'' +
                '}';
    }
}
