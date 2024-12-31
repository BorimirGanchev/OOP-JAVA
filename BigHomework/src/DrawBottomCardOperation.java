import org.elsys.cardgame.api.*;

public class DrawBottomCardOperation implements Operation {
    @Override
    public String getName() {
        return "draw_bottom_card";
    }

    @Override
    public void execute(Game game) {
        Deck deck = game.getDeck();
        if (deck.size() == 0) {
            throw new CardException("Not enough cards in deck.");
        }
        System.out.println(deck.drawBottomCard());
    }
}
