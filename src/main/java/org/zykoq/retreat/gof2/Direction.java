package org.zykoq.retreat.gof2;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public enum Direction {
    UPPER, LOWER_LEFT;

    public int shiftHorizontal(int horizontal) {
        switch (this) {
            case UPPER:
                return horizontal;
            case LOWER_LEFT:
                return --horizontal;
        }
        return 0;
    }

    public int shiftVertical(int vertical) {
        switch (this) {
            case UPPER:
                return --vertical;
            case LOWER_LEFT:
                return ++vertical;
        }
        return 0;
    }
}
