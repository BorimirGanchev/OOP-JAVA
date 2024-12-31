import org.elsys.cardgame.api.*;

import java.util.ArrayList;
import java.util.List;

public class GameFactory {
    public static Game createGame(Deck deck) {
        List<Operation> operations = new ArrayList<>();
        operations.add(new SizeOperation());
        operations.add(new DrawTopCardOperation());
        operations.add(new DrawBottomCardOperation());
        operations.add(new TopCardOperation());
        operations.add(new BottomCardOperation());
        operations.add(new ShuffleOperation());
        operations.add(new SortOperation());
        operations.add(new DealOperation());

        return new GameImpl(deck, operations);
    }
}
