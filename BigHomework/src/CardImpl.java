import org.elsys.cardgame.api.*;

public class CardImpl implements Card {
    private final Rank rank;
    private final Suit suit;

    public CardImpl(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card other) {
        int suitComparison = this.suit.compareTo(other.getSuit());
        if (suitComparison != 0) {
            return suitComparison;
        }
        return this.rank.compareTo(other.getRank());
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CardImpl card = (CardImpl) obj;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = rank.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }
}
