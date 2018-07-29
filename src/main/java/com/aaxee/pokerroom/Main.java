package com.aaxee.pokerroom;

import com.aaxee.pokerroom.engine.*;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        dealer.addPlayer(new AsyncPlayerWrapper(new StupidPlayer("Nick")));
        dealer.addPlayer(new AsyncPlayerWrapper(new StupidPlayer("Peter")));
        dealer.startGame();
        try {
            AsyncConfiguration.executorService.awaitTermination(AsyncConfiguration.WAITING_TIME, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End game");
    }
}
