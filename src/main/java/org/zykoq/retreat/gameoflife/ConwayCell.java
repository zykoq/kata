package org.zykoq.retreat.gameoflife;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class ConwayCell {


    private final Status status;

    public ConwayCell(Status status) {
        this.status = status;
    }

    public boolean isAlive() {
        return true;
    }

    public Status getStatus() {
        return status;
    }
}
