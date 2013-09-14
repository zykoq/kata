package org.zykoq.retreat.gameoflife;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class Board {

    private final CellContainer container = new CellContainer();

    public Board(final Status... statii) {
        for (Status status : statii) {
            container.add(status);
        }
    }

    public boolean isNotEmpty() {
        return true;
    }

    public ConwayCell getCell(int i) {
        return container.get(i);
    }
}
