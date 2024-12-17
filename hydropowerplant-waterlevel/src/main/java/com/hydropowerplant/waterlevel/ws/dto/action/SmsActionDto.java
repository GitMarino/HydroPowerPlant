package com.hydropowerplant.waterlevel.ws.dto.action;

import com.hydropowerplant.waterlevel.businesslogic.annotation.PhoneNumber;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class SmsActionDto {

    @NotBlank
    private String name;

    @NotBlank
    @PhoneNumber
    private String phoneNumber;

    @NotBlank
    private String text;

    @NotBlank
    private String type;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SmsActionDto that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(text, that.text) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, text, type);
    }

    @Override
    public String toString() {
        return "SmsActionDto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
