package org.zykoq.tennis;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class Match {

    private final Map<Player, Score> game = new EnumMap<>(Player.class);

    public Match() {
        game.put(Player.ONE, Score.LOVE);
        game.put(Player.TWO, Score.LOVE);
    }

    public void addScore(Player player) {
        Score score = game.get(player);
        Score opponentScore = game.get(player.getOpponent());
//        if (isDeuce(score, opponentScore)) {
//            score =
//        }
        game.put(player, score.increase());
    }

    public int getScore(Player player) {
        return game.get(player).getValue();
    }
}
