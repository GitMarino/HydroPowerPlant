package com.hydropowerplant.waterlevel.database.key;

import com.hydropowerplant.waterlevel.database.entity.Action;
import com.hydropowerplant.waterlevel.database.entity.Scenario;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class ScenarioActionRelationshipKey {

    @ManyToOne
    @JoinColumn(name = "action_id", nullable = false)
    Action action;

    @ManyToOne
    @JoinColumn(name = "scenario_id", nullable = false)
    Scenario scenario;

    public Action getAction() {
        return action;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScenarioActionRelationshipKey that)) return false;
        return Objects.equals(action, that.action) && Objects.equals(scenario, that.scenario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, scenario);
    }

    @Override
    public String toString() {
        return "ScenarioActionRelationshipKey{" +
                "action=" + action +
                ", scenario=" + scenario +
                '}';
    }
}
