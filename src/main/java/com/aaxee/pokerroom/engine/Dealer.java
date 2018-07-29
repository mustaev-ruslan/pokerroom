package com.aaxee.pokerroom.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Dealer {

    private Table table;
    private List<Player> players;

    private int buttonPosition;

    public Dealer() {
        players = new ArrayList<>();
        table = new Table();
    }

    public void startGame() {
        giveSeats(players);
        randomButton();
        while (players.size() != 1) {
            round();
        }
    }

    private void randomButton() {
        Random random = new Random();
        buttonPosition = random.nextInt(players.size());
    }

    private void round() {
        Deck deck = new Deck();
        for (Player player : players) {
            Hand hand = new Hand(deck.nextCard(), deck.nextCard());
            player.getHand(hand);
        }
    }

    private void moveButton() {
        buttonPosition = (buttonPosition + 1) % players.size();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    private void giveSeats(List<Player> players) {
        List<Player> shuffledPlayers = new ArrayList<>(players);
        Collections.shuffle(shuffledPlayers);
        table.setPlayers(shuffledPlayers);
        notifyPlayers();
    }

    private void notifyPlayers() {
        for (Player player : table.getPlayers()) {
            player.lookTable(table);
        }
    }
}
