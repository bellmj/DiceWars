package com.jack.dicewars.dice_wars;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import com.jack.dicewars.dice_wars.game.Configuration;
import com.jack.dicewars.dice_wars.game.Game;
import com.jack.dicewars.dice_wars.setup.GameConfigActivity;

/**
 * This activity will handle displaying the progression of a DiceWars game.
 */
public class MainGameActivity extends Activity {

    /**
     * The root container for DiceWars game logic.
     */
    private Game game;

    private AbstractBoardView boardView;

    /**
     * Loads the configuration to use for the game.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main_game);

        Intent i = getIntent();
        this.game = new Game(new Configuration(i));
        game.start();

        // Choose the game mode to run
        if (game.getAppMode() == Debug.gridText.f) {
            boardView = new GridTextBoardView(game.getBoard(), this);
        } else {
            throw new EnumConstantNotPresentException(Debug.class, "App mode does not exist");
        }
        boardView.apply((ViewGroup) findViewById(R.id.boardContainer));
        update();
    }

    /**
     * Updates the view based on the state of {@game}.
     */
    private void update() {
        //is this a(n abstract) method of boardview? or is that just a part of the implementation?
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.hardware_back_in_game).setTitle(R.string.common_warning);

        builder.setMessage(R.string.hardware_back_in_game).setPositiveButton(R.string.common_continue, new
                DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.i(Debug.nav.s, "Go to Game Config");
                goToGameConfig();
            }

        }).setNegativeButton(R.string.common_cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.i(Debug.nav.s, "cancel");
            }
        });
        // Create the AlertDialog object and return it
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Debug. This method should block the back button. Ends the game, and sends the intent for this game back to the
     * configuration activity.
     */
    private void goToGameConfig() {
        Intent i = new Intent(this, GameConfigActivity.class);
        i.putExtras(GameConfigActivity.defaultExtras());
        finish();
    }
}