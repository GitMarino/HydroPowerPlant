package com.hydropowerplant.waterlevel.ws.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5053901116399930089L;

    private String message;

    public ResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseDto that)) return false;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(message);
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "message='" + message + '\'' +
                '}';
    }
}
