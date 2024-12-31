import org.elsys.cardgame.api.*;

import java.util.List;

public class GameImpl implements Game {
    private final Deck deck;
    private final List<Operation> operations;
    private Hand lastHand;

    public GameImpl(Deck deck, List<Operation> operations) {
        this.deck = deck;
        this.operations = operations;
    }

    @Override
    public Deck getDeck() {
        return deck;
    }

    @Override
    public Hand getLastHand() {
        return lastHand;
    }

    @Override
    public void setLastHand(Hand hand) {
        this.lastHand = hand;
    }

    @Override
    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public void process(String operationName) {
        for (Operation operation : operations) {
            if (operation.getName().equals(operationName)) {
                operation.execute(this);
                return;
            }
        }
        throw new IllegalArgumentException("Unknown operation: " + operationName);
    }
}
