package org.elsys.cardgame.api;

import java.util.List;

public interface Game {
    Deck getDeck();
    Hand getLastHand();
    void setLastHand(Hand hand);
    List<Operation> getOperations();
    void process(String operationName);
}
