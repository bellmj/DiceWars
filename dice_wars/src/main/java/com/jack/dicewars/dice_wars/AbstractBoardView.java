package com.jack.dicewars.dice_wars;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

/**
 * Created by Jack Mueller on 2/28/15.
 *
 * This class is the superclass for a game Board, which defines basic responsibilities like generating random versions
 * of itself within Configuration parameters and responding to user input. It also holds a ties the {@link com.jack
 * .dicewars.dice_wars.TerritoryView} to the actual Android View that represents it through the Activity.
 */
public abstract class AbstractBoardView {

    /**
     * This is the {@link com.jack.dicewars.dice_wars.MainGameActivity} that the board is being used on.
     */
    protected Context context;

    protected Map<AbstractTerritoryView, View> territoryViewMap;

    /**
     * Puts programmatically generated views into the supplied viewPort based on the {@link #territoryViewMap} and
     * any other Views that are defined by the subclass implementation.
     * @param viewPort The entire container allocated to viewing the board.
     * @return A modified version of the viewPort that has a representation of territoryViewMap as its child
     * nodes.
     */
    public abstract View apply(ViewGroup viewPort);

}
