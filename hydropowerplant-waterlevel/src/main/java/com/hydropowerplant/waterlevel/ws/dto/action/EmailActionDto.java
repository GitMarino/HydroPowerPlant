package com.hydropowerplant.waterlevel.ws.dto.action;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class EmailActionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -3874322908279588911L;

    @NotNull
    @Email
    private String address;

    @NotBlank
    private String name;

    private String subject;

    @NotBlank
    private String text;

    @NotBlank
    private String type;

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmailActionDto that)) return false;
        return Objects.equals(address, that.address) && Objects.equals(name, that.name) && Objects.equals(subject, that.subject) && Objects.equals(text, that.text) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name, subject, text, type);
    }

    @Override
    public String toString() {
        return "EmailActionDto{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
