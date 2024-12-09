package com.hydropowerplant.waterlevel.businesslogic.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CachedThreadPool {

    private final transient ExecutorService executor = Executors.newCachedThreadPool();

    public ExecutorService getExecutor() {
        return executor;
    }

}
