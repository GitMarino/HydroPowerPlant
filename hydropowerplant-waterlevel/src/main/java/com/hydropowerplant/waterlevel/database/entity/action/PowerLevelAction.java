package com.hydropowerplant.waterlevel.database.entity.action;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = PowerLevelAction.TABLE_NAME)
public class PowerLevelAction {

    public static final String TABLE_NAME = "power_level_action";

    @Id
    @Column(name = "action_id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "action_id")
    private Action action;

    @Column(name = "formula", nullable = false)
    private String formula;

    public Integer getId() {
        return id;
    }

    public String getFormula() {
        return formula;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerLevelAction that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(action, that.action) && Objects.equals(formula, that.formula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, formula);
    }

    @Override
    public String toString() {
        return "PowerLevelAction{" +
                "id=" + id +
                ", action=" + action +
                ", formula='" + formula + '\'' +
                '}';
    }
}
