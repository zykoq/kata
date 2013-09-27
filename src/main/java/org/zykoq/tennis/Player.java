package org.zykoq.tennis;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public enum Player {
    ONE, TWO;

    public Player getOpponent() {
        return this == ONE ? TWO : ONE;
    }
}
