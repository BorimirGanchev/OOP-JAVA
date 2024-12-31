import org.elsys.cardgame.api.*;

public class DrawTopCardOperation implements Operation {
    @Override
    public String getName() {
        return "draw_top_card";
    }

    @Override
    public void execute(Game game) {
        Deck deck = game.getDeck();
        if (deck.size() == 0) {
            throw new CardException("Not enough cards in deck.");
        }
        System.out.println(deck.drawTopCard());
    }
}
