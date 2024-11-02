package com.hydropowerplant.waterlevel.database.entity.action;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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

    @Column(name = "address")
    private String address;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text")
    private String text;

    public Integer getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getAddress() {
        return address;
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
}
