import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Suit;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Hand;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Card> initialCards = parseCards(scanner.nextLine());
        Deck currentDeck = null;

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            switch (input.toLowerCase()) {
                case "war":
                    if (initialCards.size() < 52) {
                        System.out.println("ERROR: Not enough cards for War");
                    } else {
                        currentDeck = DeckFactory.createWarDeck(initialCards);
                    }
                    break;
                case "belote":
                    if (initialCards.size() < 32) {
                        System.out.println("ERROR: Not enough cards for Belote");
                    } else {
                        currentDeck = DeckFactory.createBeloteDeck(initialCards);
                    }
                    break;
                case "santase":
                    if (initialCards.size() < 24) {
                        System.out.println("ERROR: Not enough cards for Santase");
                    } else {
                        currentDeck = DeckFactory.createSantaseDeck(initialCards);
                    }
                    break;
                default:
                    if (currentDeck == null) {
                        System.out.println("ERROR: No deck");
                    } else {
                        try {
                            processOperation(input, currentDeck);
                        } catch (CardException e) {
                            System.out.println(e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println("ERROR: Unknown operation");
                        }
                    }
                    break;
            }
        }
    }

    private static List<Card> parseCards(String input) {
        List<Card> cards = new ArrayList<>();
        String[] cardStrings = input.split("\\s+");
        for (String cardStr : cardStrings) {
            cards.add(parseCard(cardStr));
        }
        return cards;
    }

    private static Card parseCard(String cardStr) {
        if (cardStr.length() < 2) {
            throw new IllegalArgumentException("Invalid card format: " + cardStr);
        }
        char suitChar = cardStr.charAt(0);
        String rankStr = cardStr.substring(1);

        Suit suit = switch (suitChar) {
            case 'S' -> Suit.SPADES;
            case 'H' -> Suit.HEARTS;
            case 'D' -> Suit.DIAMONDS;
            case 'C' -> Suit.CLUBS;
            default -> throw new IllegalArgumentException("Invalid suit: " + suitChar);
        };

        Rank rank = switch (rankStr) {
            case "2" -> Rank.TWO;
            case "3" -> Rank.THREE;
            case "4" -> Rank.FOUR;
            case "5" -> Rank.FIVE;
            case "6" -> Rank.SIX;
            case "7" -> Rank.SEVEN;
            case "8" -> Rank.EIGHT;
            case "9" -> Rank.NINE;
            case "10" -> Rank.TEN;
            case "J" -> Rank.JACK;
            case "Q" -> Rank.QUEEN;
            case "K" -> Rank.KING;
            case "A" -> Rank.ACE;
            default -> throw new IllegalArgumentException("Invalid rank: " + rankStr);
        };

        return new CardImpl(rank, suit);
    }

    private static void processOperation(String operation, Deck deck) {
        switch (operation.toLowerCase()) {
            case "size" -> System.out.println(deck.size());
            case "draw_top_card" -> System.out.println(deck.drawTopCard());
            case "draw_bottom_card" -> System.out.println(deck.drawBottomCard());
            case "top_card" -> System.out.println(deck.topCard());
            case "bottom_card" -> System.out.println(deck.bottomCard());
            case "shuffle" -> {
                deck.shuffle();
                for (Card card : deck.getCards()) {
                    System.out.println(card);
                }
            }
            case "sort" -> {
                deck.sort();
                for (Card card : deck.getCards()) {
                    System.out.println(card);
                }
            }
            case "deal" -> {
                Hand hand = deck.deal();
                for (Card card : hand.getCards()) {
                    System.out.println(card);
                }
            }
            default -> throw new IllegalArgumentException("Unknown operation");
        }
    }
}
