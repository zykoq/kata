package org.zykoq.retreat.gameoflife;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class CellContainer {


    public void add(Status status) {
        ConwayCell cell = new ConwayCell(status);
    }

    public ConwayCell get(int i) {
        if (i == 0) {
            return new ConwayCell(Status.DEAD);
        }
        return new ConwayCell(Status.ALIVE);
    }
}
