import domain.Game;
import domain.Ladder;
import view.Input;
import view.Output;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String TERMINATE = "춘식이";

    public static void main(String[] args) {
        List<String> players = Arrays.asList(Input.getPlayer());
        List<String> results = Arrays.asList(Input.getResult());
        int heightOfLadder = Input.getNumber();

        Ladder ladder = new Ladder(players, results, heightOfLadder);
        Output.messageAboutLadder(ladder);
        Game game = new Game(ladder);

        String player = "";
        while (!player.equals(TERMINATE)) {
            player = Input.pickPlayer();
            Output.messageAboutGame(game.play(player));
        }
        Input.close();
    }
}
