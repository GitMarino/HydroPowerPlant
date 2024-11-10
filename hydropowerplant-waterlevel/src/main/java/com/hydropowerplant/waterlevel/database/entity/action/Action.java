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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToOne(mappedBy = "action", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private EmailAction emailAction;

    @OneToOne(mappedBy = "action", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SmsAction smsAction;

    @OneToOne(mappedBy = "action", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PowerLevelAction powerLevelAction;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public EmailAction getEmailAction() {
        return emailAction;
    }

    public SmsAction getSmsAction() {
        return smsAction;
    }

    public PowerLevelAction getPowerLevelAction() {
        return powerLevelAction;
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

    public void setEmailAction(EmailAction emailAction) {
        this.emailAction = emailAction;
    }

    public void setSmsAction(SmsAction smsAction) {
        this.smsAction = smsAction;
    }

    public void setPowerLevelAction(PowerLevelAction powerLevelAction) {
        this.powerLevelAction = powerLevelAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action action)) return false;
        return Objects.equals(id, action.id) && Objects.equals(name, action.name) && Objects.equals(type, action.type) && Objects.equals(emailAction, action.emailAction) && Objects.equals(smsAction, action.smsAction) && Objects.equals(powerLevelAction, action.powerLevelAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, emailAction, smsAction, powerLevelAction);
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", emailAction=" + emailAction +
                ", smsAction=" + smsAction +
                ", powerLevelAction=" + powerLevelAction +
                '}';
    }
}
