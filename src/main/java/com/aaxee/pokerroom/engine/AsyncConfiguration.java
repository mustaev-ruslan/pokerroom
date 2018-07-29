package com.aaxee.pokerroom.engine;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class AsyncConfiguration {

    public final static int MAX_PLAYERS = 9;
    public final static int WAITING_TIME = 15;
    public final static ExecutorService executorService = Executors.newFixedThreadPool(MAX_PLAYERS);
}
