package org.empire.animelis.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.empire.animelis.R;
import org.empire.animelis.ui.anime.AddAnimeDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class AbstractFragment extends Fragment {

    private static final String TAG = AbstractFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
               /* AddAnimeDialogFragment dialog = AddAnimeDialogFragment.newInstance("","");
                dialog.show(getFragmentManager(), TAG);
            }
        });
    }*/
}
