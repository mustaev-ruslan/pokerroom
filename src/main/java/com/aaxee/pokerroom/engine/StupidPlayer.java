package com.aaxee.pokerroom.engine;

import java.util.List;

public class StupidPlayer implements Player {
    private final String name;
    private Hand hand;

    public StupidPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Action chooseAction(List<Action> actions) {
        return actions.get(0);
    }

    @Override
    public void lookTable(Table table) {
        showMyCards();
    }

    @Override
    public void getHand(Hand hand) {
        this.hand = hand;
        showMyCards();
    }

    private void showMyCards() {
        System.out.println(name+ " " + hand);
    }
}
