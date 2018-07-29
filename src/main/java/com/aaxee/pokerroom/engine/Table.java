package com.aaxee.pokerroom.engine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Table {
    List<Player> players;

    public void addPlayer(Player player) {
        players.add(player);
    }
}
