package com.jack.dicewars.dice_wars.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.jack.dicewars.dice_wars.Color;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jack on 1/28/15.
 *
 * This class represents a player of a DiceWars game. It can have a name and a Color that it uses to represent itself.
 * It can have various statuses that describe it's most current role at many times including before, during and
 * after the game.
 */
public class Player implements Parcelable {

    // TODO change these strings to a Status enum
    public static final String STATUS_YOU = "YOU";
    public static final String STATUS_AI = "AI";
    public static final String STATUS_HUMAN = "HUMAN";
    public static final String STATUS_CLOSED = "CLOSED";

    private String name;
    private String status;
    private Color color;

    /**
     * A list of territories that a Player knows it owns. This data is retrievable by querying the board, but this way
     * the filter is basically cached for each Player.
     */
    private List<Territory> territories = new LinkedList<>();

    /**
     *
     * @param name The player's screen name.
     * @param status The player's relationship to the game defined by {@link #STATUS_YOU}
     * @param color The ID of the color the player is using.
     */
    public Player(String name, String status, Color color) {
        this.name = name;
        this.status = status;
        this.color = color;
    }

    /**
     * Enables Parcelable interface.
     *
     * @param in Parceled Player
     */
    protected Player(Parcel in) {
        name = in.readString();
        status = in.readString();
        color = in.readParcelable(Color.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(status);
        dest.writeParcelable(getColor(), flags);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    /**
     *
     * @return The Color this Player uses to represent itself on territories and elsewhere.
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @return The Status this Player is currently has. Can change throughout the Game.
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @return The list of Territories owned by this Player.
     */
    public List<Territory> getTerritories() {
        return territories;
    }

    /**
     *
     * @param territory The Territory this Player will register with itself.
     */
    public void claimOwnership(Territory territory) {
        territories.add(territory);
    }

    /**
     *
     * @param territory The Territory this Player will unregister from its cache.
     */
    public void loseOwnership(Territory territory) {
        territories.remove(territory);
    }
}