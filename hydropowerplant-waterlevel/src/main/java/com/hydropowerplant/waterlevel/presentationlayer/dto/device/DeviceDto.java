package com.hydropowerplant.waterlevel.presentationlayer.dto.device;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class DeviceDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4583358869346738599L;

    @NotBlank
    private String address;

    @NotBlank
    private String name;

    @NotNull
    private Double powerLevel;

    @NotBlank
    private String serial;

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public Double getPowerLevel() {
        return powerLevel;
    }

    public String getSerial() {
        return serial;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerLevel(Double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DeviceDto deviceDto)) return false;
        return Objects.equals(address, deviceDto.address) && Objects.equals(name, deviceDto.name) && Objects.equals(powerLevel, deviceDto.powerLevel) && Objects.equals(serial, deviceDto.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name, powerLevel, serial);
    }

    @Override
    public String toString() {
        return "DeviceDto{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                ", serial='" + serial + '\'' +
                '}';
    }
    
}
