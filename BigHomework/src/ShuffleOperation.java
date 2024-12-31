import org.elsys.cardgame.api.*;

public class ShuffleOperation implements Operation {
    @Override
    public String getName() {
        return "shuffle";
    }

    @Override
    public void execute(Game game) {
        Deck deck = game.getDeck();
        deck.shuffle();
        System.out.println(deck.getCards());
    }
}
