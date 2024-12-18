package com.hydropowerplant.waterlevel.businesslayer.exception;

import java.io.Serial;

public class ItemNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1587874953256485754L;

    public ItemNotFoundException(String message) {
        super(message);
    }

}