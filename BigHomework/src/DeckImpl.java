import org.elsys.cardgame.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckImpl implements Deck {
    private List<Card> cards;
    private int handSize;

    public DeckImpl(List<Card> cards, int handSize) {
        this.cards = new ArrayList<>(cards);
        this.handSize = handSize;
    }

    @Override
    public Card drawTopCard() {
        if (cards.isEmpty()) {
            throw new CardException("Not enough cards in deck.");
        }
        return cards.remove(0);
    }

    @Override
    public Card drawBottomCard() {
        if (cards.isEmpty()) {
            throw new CardException("Not enough cards in deck.");
        }
        return cards.remove(cards.size() - 1);
    }

    @Override
    public Card topCard() {
        if (cards.isEmpty()) {
            throw new CardException("Not enough cards in deck.");
        }
        return cards.get(0);
    }

    @Override
    public Card bottomCard() {
        if (cards.isEmpty()) {
            throw new CardException("Not enough cards in deck.");
        }
        return cards.get(cards.size() - 1);
    }

    @Override
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void sort() {
        cards.sort(Card::compareTo);
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public int handSize() {
        return handSize;
    }

    @Override
    public Hand deal() {
        if (cards.size() < handSize) {
            throw new CardException("Not enough cards in deck.");
        }
        List<Card> handCards = new ArrayList<>(cards.subList(0, handSize));
        cards.subList(0, handSize).clear();
        return new HandImpl(handCards);
    }
}
