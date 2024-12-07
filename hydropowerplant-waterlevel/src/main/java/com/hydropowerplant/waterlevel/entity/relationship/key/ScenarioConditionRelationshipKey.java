package com.hydropowerplant.waterlevel.entity.relationship.key;

import com.hydropowerplant.waterlevel.entity.Scenario;
import com.hydropowerplant.waterlevel.entity.condition.Condition;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class ScenarioConditionRelationshipKey {

    @ManyToOne
    @JoinColumn(name = "condition_id", nullable = false)
    Condition condition;

    @ManyToOne
    @JoinColumn(name = "scenario_id", nullable = false)
    Scenario scenario;

    public ScenarioConditionRelationshipKey(Condition condition, Scenario scenario) {
        this.condition = condition;
        this.scenario = scenario;
    }

    public Condition getCondition() {
        return condition;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScenarioConditionRelationshipKey that)) return false;
        return Objects.equals(condition, that.condition) && Objects.equals(scenario, that.scenario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, scenario);
    }

    @Override
    public String toString() {
        return "ScenarioConditionRelationshipKey{" +
                "condition=" + condition +
                ", scenario=" + scenario +
                '}';
    }
}
