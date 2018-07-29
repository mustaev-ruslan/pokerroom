package com.aaxee.pokerroom.engine;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface Player {

    String getName();

    Action chooseAction(List<Action> actions) throws ExecutionException, InterruptedException;

    void lookTable(Table table);

    void getHand(Hand hand);

}
