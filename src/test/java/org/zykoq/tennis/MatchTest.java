package org.zykoq.tennis;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class MatchTest {

    @Test
    public void ScoreFirst() {
        Match match = addScores(1, 0);
        assertEquals(15, match.getScore(Player.ONE));
    }

    @Test
    public void LoveSecond() {
        Match match = addScores(1, 0);
        assertEquals(0, match.getScore(Player.TWO));
    }

    @Test
    public void FifteenLove() {
        Match match = addScores(1, 0);
        assertEquals(15, match.getScore(Player.ONE));
        assertEquals(0, match.getScore(Player.TWO));
    }

    @Test
    public void ThirtyLove() {
        Match match = addScores(2, 0);
        assertEquals(30, match.getScore(Player.ONE));
        assertEquals(0, match.getScore(Player.TWO));
    }

    @Test
    public void FifteenBoth() {
        Match match = addScores(1, 1);
        assertEquals(15, match.getScore(Player.ONE));
        assertEquals(15, match.getScore(Player.TWO));
    }

    @Test
    public void ThirtyBoth() {
        Match match = addScores(2, 2);
        assertEquals(30, match.getScore(Player.ONE));
        assertEquals(30, match.getScore(Player.TWO));
    }

    @Test
    public void Deuce() {
        Match match = addScores(3, 3);
        assertEquals(40, match.getScore(Player.ONE));
        assertEquals(40, match.getScore(Player.TWO));
    }

    @Test
    public void FortyThirty() {
        Match match = addScores(3, 2);
        assertEquals(40, match.getScore(Player.ONE));
        assertEquals(30, match.getScore(Player.TWO));
    }

    @Test
    public void Advantage() {
        Match match = addScores(4, 3);
//        assertEquals(40, match.getScore(Player.ONE));
        assertEquals(40, match.getScore(Player.TWO));
    }

    private Match addScores(int firstPlayerScores, int secondPlayerScores) {
        Match match = new Match();
        for (int i = 0; i < firstPlayerScores; i++) {
            match.addScore(Player.ONE);
        }
        for (int i = 0; i < secondPlayerScores; i++) {
            match.addScore(Player.TWO);
        }
        return match;
    }


}
