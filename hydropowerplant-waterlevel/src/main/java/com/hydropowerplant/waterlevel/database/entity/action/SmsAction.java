package com.hydropowerplant.waterlevel.database.entity.action;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = SmsAction.TABLE_NAME)
public class SmsAction {

    public static final String TABLE_NAME = "sms_action";

    @Id
    @Column(name = "action_id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "action_id")
    private Action action;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "text")
    private String text;

    public Integer getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getText() {
        return text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setText(String text) {
        this.text = text;
    }
}
