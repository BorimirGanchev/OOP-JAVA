package org.elsys.cardgame.api;

import java.util.List;

public interface Deck {
    Card drawTopCard();
    Card drawBottomCard();
    Card topCard();
    Card bottomCard();
    List<Card> getCards();
    void shuffle();
    void sort();
    int size();
    int handSize();
    Hand deal();
}