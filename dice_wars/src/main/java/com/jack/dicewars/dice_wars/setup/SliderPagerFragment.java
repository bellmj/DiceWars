package com.jack.dicewars.dice_wars.setup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jack.dicewars.dice_wars.R;

/**
 * @author Jack Mueller
 *         Taken from developer.android.com/training
 */
public class SliderPagerFragment extends Fragment {

    /**
     * The page Id of this fragment.
     */
    private int pageId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Use a_help_page as the template for these pages
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.f_how_to_play_page, container, false);

        // Add the passed in image to the background
        Bundle pageInfo = getArguments();
        pageId = pageInfo.getInt("pageId");
        rootView.setBackground(getResources().getDrawable(pageId));

        return rootView;
    }

}
