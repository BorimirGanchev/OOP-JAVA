import org.elsys.cardgame.api.*;

public class TopCardOperation implements Operation {
    @Override
    public String getName() {
        return "top_card";
    }

    @Override
    public void execute(Game game) {
        Deck deck = game.getDeck();
        if (deck.size() == 0) {
            throw new CardException("Not enough cards in deck.");
        }
        System.out.println(deck.topCard());
    }
}
