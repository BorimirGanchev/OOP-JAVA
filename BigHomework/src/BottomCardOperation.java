import org.elsys.cardgame.api.*;

public class BottomCardOperation implements Operation {
    @Override
    public String getName() {
        return "bottom_card";
    }

    @Override
    public void execute(Game game) {
        Deck deck = game.getDeck();
        if (deck.size() == 0) {
            throw new CardException("Not enough cards in deck.");
        }
        
        System.out.println(deck.bottomCard());
    }
}
