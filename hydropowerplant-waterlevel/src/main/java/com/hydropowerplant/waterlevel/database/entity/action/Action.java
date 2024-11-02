package com.hydropowerplant.waterlevel.database.entity.action;

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
@Table(name = Action.TABLE_NAME)
public class Action {

    public static final String TABLE_NAME = "action";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "action", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private EmailAction emailAction;

    @OneToOne(mappedBy = "action", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SmsAction smsAction;

    @Column(name = "type", nullable = false)
    private String type;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action action)) return false;
        return Objects.equals(id, action.id) && Objects.equals(emailAction, action.emailAction) && Objects.equals(smsAction, action.smsAction) && Objects.equals(type, action.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emailAction, smsAction, type);
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", emailAction=" + emailAction +
                ", smsAction=" + smsAction +
                ", type='" + type + '\'' +
                '}';
    }
}
