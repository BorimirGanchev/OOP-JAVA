import org.elsys.cardgame.api.*;


import java.util.List;
public class DeckFactory {
    public static Deck createWarDeck(List<Card> cards) {
        if (cards.size() < 52) {
            throw new IllegalArgumentException("Not enough cards for War");
        }
        List<Card> warCards = cards.subList(0, 52);
        return new DeckImpl(warCards, 26);
    }

    public static Deck createBeloteDeck(List<Card> cards) {
        if (cards.size() < 32) {
            throw new IllegalArgumentException("Not enough cards for Belote");
        }
        List<Card> beloteCards = cards.subList(0, 32);
        return new DeckImpl(beloteCards, 8);
    }

    public static Deck createSantaseDeck(List<Card> cards) {
        if (cards.size() < 24) {
            throw new IllegalArgumentException("Not enough cards for Santase");
        }
        List<Card> santaseCards = cards.subList(0, 24);
        return new DeckImpl(santaseCards, 6);
    }
}
