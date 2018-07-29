package com.aaxee.pokerroom.engine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Card {
    private Suit suit;
    private Rank rank;
}
