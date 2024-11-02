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
}
