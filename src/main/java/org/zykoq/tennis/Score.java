package org.zykoq.tennis;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public enum Score {
    LOVE(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40);
    private final int value;

    private Score(int value) {
        this.value = value;
    }

    public Score increase() {
        final Score result;
        switch (this) {
            case LOVE:
                result = FIFTEEN;
                break;
            case FIFTEEN:
                result = THIRTY;
                break;
            case THIRTY:
                result = FORTY;
                break;
            default:
                result = LOVE;
                break;
        }
        return result;
    }

    public int getValue() {
        return value;
    }
}
