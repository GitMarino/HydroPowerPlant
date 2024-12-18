package com.hydropowerplant.waterlevel.businesslayer.object.property;

import com.hydropowerplant.waterlevel.businesslayer.annotation.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
@Configuration
@ConfigurationProperties(prefix = "twilio")
public class SmsProperties {

    @NotBlank
    private String accountSid;

    @NotBlank
    private String authToken;

    @NotBlank
    @PhoneNumber
    private String phoneNumber;

    public String getAccountSid() {
        return accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SmsProperties that)) return false;
        return Objects.equals(accountSid, that.accountSid) && Objects.equals(authToken, that.authToken) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, authToken, phoneNumber);
    }

    @Override
    public String toString() {
        return "SmsProperties{" +
                "accountSid='" + accountSid + '\'' +
                ", authToken='" + authToken + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
