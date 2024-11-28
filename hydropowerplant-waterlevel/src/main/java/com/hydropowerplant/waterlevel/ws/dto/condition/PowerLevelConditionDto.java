package com.hydropowerplant.waterlevel.ws.dto.condition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class PowerLevelConditionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5641411984888211152L;

    private List<String> devices;

    private String name;

    private String type;

    @NotEmpty
    public List<String> getDevices() {
        return devices;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    @NotBlank
    public String getType() {
        return type;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

}
