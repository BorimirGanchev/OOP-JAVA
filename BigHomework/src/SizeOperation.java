import org.elsys.cardgame.api.*;

public class SizeOperation implements Operation {
    @Override
    public String getName() {
        return "size";
    }

    @Override
    public void execute(Game game) {
        System.out.println(game.getDeck().size());
    }
}
