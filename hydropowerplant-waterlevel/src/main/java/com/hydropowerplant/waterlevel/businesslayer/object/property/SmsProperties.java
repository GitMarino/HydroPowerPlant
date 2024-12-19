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
    @PhoneNumber
    private String number;

    @NotBlank
    private String password;

    @NotBlank
    private String username;

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SmsProperties that)) return false;
        return Objects.equals(number, that.number) && Objects.equals(password, that.password) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, password, username);
    }

    @Override
    public String toString() {
        return "SmsProperties{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
    
}
