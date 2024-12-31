import org.elsys.cardgame.api.*;

public class DealOperation implements Operation {
    @Override
    public String getName() {
        return "deal";
    }

    @Override
    public void execute(Game game) {
        Deck deck = game.getDeck();
        if (deck.size() < deck.handSize()) {
            throw new CardException("Not enough cards in deck.");
        }
        Hand hand = deck.deal();
        game.setLastHand(hand);
        System.out.println(hand.getCards());
    }
}
