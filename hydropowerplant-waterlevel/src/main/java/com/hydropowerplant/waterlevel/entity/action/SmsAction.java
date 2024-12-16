package com.hydropowerplant.waterlevel.entity.action;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity(name = SmsAction.TABLE_NAME)
public class SmsAction extends Action {

    public static final String TABLE_NAME = "sms_action";

    @Column(name = "phonenumber", nullable = false)
    private String phoneNumber;

    @Column(name = "text", nullable = false)
    private String text;

    public SmsAction() {
        
    }

    public SmsAction(Integer id, String name, String type, String phoneNumber, String text) {
        super(id, name, type);
        this.phoneNumber = phoneNumber;
        this.text = text;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getText() {
        return text;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SmsAction smsAction)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(phoneNumber, smsAction.phoneNumber) && Objects.equals(text, smsAction.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber, text);
    }

    @Override
    public String toString() {
        return "SmsAction{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
