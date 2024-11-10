package com.hydropowerplant.waterlevel.businesslogic.object;

import java.util.Objects;

public class ActionContext {

    private String address;

    private String formula;

    private String phoneNumber;

    private String subject;

    private String text;

    public String getAddress() {
        return address;
    }

    public String getFormula() {
        return formula;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        if (!(o instanceof ActionContext that)) return false;
        return Objects.equals(address, that.address) && Objects.equals(formula, that.formula) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(subject, that.subject) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, formula, phoneNumber, subject, text);
    }

    @Override
    public String toString() {
        return "ActionContext{" +
                "address='" + address + '\'' +
                ", formula='" + formula + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
