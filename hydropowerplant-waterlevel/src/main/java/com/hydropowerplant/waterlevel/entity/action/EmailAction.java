package com.hydropowerplant.waterlevel.entity.action;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity(name = EmailAction.TABLE_NAME)
public class EmailAction extends Action {

    public static final String TABLE_NAME = "email_action";

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text", nullable = false)
    private String text;

    public EmailAction(Integer id, String name, String type, String address, String subject, String text) {
        super(id, name, type);
        this.address = address;
        this.subject = subject;
        this.text = text;
    }

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmailAction that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(address, that.address) && Objects.equals(subject, that.subject) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, subject, text);
    }

    @Override
    public String toString() {
        return "EmailAction{" +
                "address='" + address + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
