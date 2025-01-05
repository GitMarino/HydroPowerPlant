package com.hydropowerplant.waterlevel.businesslayer.service.threadpool;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SingleThreadPool {

    private final transient ExecutorService executor = Executors.newSingleThreadExecutor();

    public ExecutorService getExecutor() {
        return executor;
    }
    
}
