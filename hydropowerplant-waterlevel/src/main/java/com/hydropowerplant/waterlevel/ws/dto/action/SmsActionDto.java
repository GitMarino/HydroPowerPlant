package com.hydropowerplant.waterlevel.ws.dto.action;

import jakarta.validation.constraints.NotBlank;

public class SmsActionDto {

    private String name;

    private String phoneNumber;

    private String text;

    private String type;

    @NotBlank
    public String getName() {
        return name;
    }

    @NotBlank
    public String getType() {
        return type;
    }

    //@PhoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @NotBlank
    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setText(String text) {
        this.text = text;
    }
}
