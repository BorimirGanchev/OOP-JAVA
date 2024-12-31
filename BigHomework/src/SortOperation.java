import org.elsys.cardgame.api.*;

public class SortOperation implements Operation {
    @Override
    public String getName() {
        return "sort";
    }

    @Override
    public void execute(Game game) {
        Deck deck = game.getDeck();
        deck.sort();
        System.out.println(deck.getCards());
    }
}
