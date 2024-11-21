package com.hydropowerplant.waterlevel.entity.action;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = EmailAction.TABLE_NAME)
public class EmailAction extends Action {

    public static final String TABLE_NAME = "email_action";

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text", nullable = false)
    private String text;

    public String getAddress() {
        return address;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

}
