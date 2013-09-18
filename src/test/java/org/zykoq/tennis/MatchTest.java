package org.zykoq.tennis;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class MatchTest {

    @Test
    public void ScoreFirst() {
        Match match = new Match();
        match.addScore(Player.ONE);
        assertEquals(15, match.getScore(Player.ONE));
    }

    @Test
    public void LoveSecond() {
        Match match = new Match();
        match.addScore(Player.ONE);
        assertEquals(0, match.getScore(Player.TWO));
    }

    @Test
    public void FifteenLove() {
        Match match = new Match();
        match.addScore(Player.ONE);
        assertEquals(15, match.getScore(Player.ONE));
        assertEquals(0, match.getScore(Player.TWO));
    }

    @Test
    public void ThirtyLove() {
        Match match = new Match();
        match.addScore(Player.ONE);
        match.addScore(Player.ONE);
        assertEquals(30, match.getScore(Player.ONE));
        assertEquals(0, match.getScore(Player.TWO));
    }

    @Test
    public void FifteenBoth() {
        Match match = new Match();
        match.addScore(Player.ONE);
        match.addScore(Player.TWO);
        assertEquals(15, match.getScore(Player.ONE));
        assertEquals(15, match.getScore(Player.TWO));
    }

    @Test
    public void ThirtyBoth() {
        Match match = new Match();
        match.addScore(Player.ONE);
        match.addScore(Player.ONE);
        match.addScore(Player.TWO);
        match.addScore(Player.TWO);
        assertEquals(30, match.getScore(Player.ONE));
        assertEquals(30, match.getScore(Player.TWO));
    }

    private void testResults(int firstPlayerScores, int secondPlayerScores) {
        Match match = new Match();
        for (int i = 0; i <= firstPlayerScores; i++) {
            match.addScore(Player.ONE);
        }
        for (int i = 0; i <= secondPlayerScores; i++) {
            match.addScore(Player.TWO);
        }
    }


}
