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
@Table(name = EmailAction.TABLE_NAME)
public class EmailAction {

    public static final String TABLE_NAME = "email_action";

    @Id
    @Column(name = "action_id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "action_id")
    private Action action;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text", nullable = false)
    private String text;

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
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
        if (this == o) return true;
        if (!(o instanceof EmailAction that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(action, that.action) && Objects.equals(address, that.address) && Objects.equals(subject, that.subject) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, address, subject, text);
    }

    @Override
    public String toString() {
        return "EmailAction{" +
                "id=" + id +
                ", action=" + action +
                ", address='" + address + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
