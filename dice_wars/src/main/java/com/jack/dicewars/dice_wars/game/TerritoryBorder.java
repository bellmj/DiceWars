package com.jack.dicewars.dice_wars.game;

/**
 * Created by Jack Mueller on 2/25/15.
 *
 * A Territory Border is a model fabrication that encapsulates internal {@link Territory} data when it is not needed.
 * A TerritoryBorders responsibilities revolve around how many other Territories (which actually means
 * TerritoryBorders, it is connected to.
 */
public class TerritoryBorder {

    /**
     * The exact number of Territories the internal Territory touches.
     */
    public static final int EDGE_MAX_COUNT = 4;
    public static final int EDGE_MID_COUNT = 4;
    public static final int EDGE_EDGE_COUNT = 3;
    public static final int EDGE_CORNER_COUNT = 2;

    private Territory[] neighbors;

    private Territory internal;

    /**
     * Creates a TerritoryBorder with an internal Territory that is owned by {@link NullPlayer} and has no dice on it.
     * This constructor does not connect this object to any other TerritoryBorders.
     *
     * @param edgeCount How many TerritoryBorders can a Player get to from this TerritoryBorder.
     */
    public TerritoryBorder(int edgeCount) {
        internal = new Territory(new NullPlayer(), 0);
        neighbors = new Territory[edgeCount];
    }

    /**
     *
     * @return The TerritoryBorders this object is connected to.
     */
    public Territory[] getNeighbors() {
        return neighbors;
    }

    /**
     *
     * @param neighbors Sets the TerritoryBorders that are reachable from this object.
     */
    public void setNeighbors(Territory[] neighbors) {
        this.neighbors = neighbors;
    }

    /**
     *
     * @return The Territory that is encapsulated by this TerritoryBorder.
     */
    public Territory getInternal() {
        return internal;
    }

    /**
     *
     * @param player The Player that now owns the Territory inside of this Border
     */
    public void setOwnerOfInternal(Player player) {
        getInternal().setOwner(player);
    }
}
