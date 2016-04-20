package org.empire.animelis.ui;

import android.support.v4.app.DialogFragment;

import org.empire.animelis.ui.anime.AddAnimeDialogFragment;
import org.empire.animelis.ui.tvshow.AddTVShowDialogFragment;

/**
 * Created by Chatofrey on 21/04/2016.
 * chatofrey@gmail.com
 * Animelis
 */
public class DialogFragmentFactory {

    public static DialogFragment getDialogFragment(final String dialogName) {
        DialogFragment dialogFragment = null;

        switch (dialogName) {
            case "Anime":
                dialogFragment = AddAnimeDialogFragment.newInstance("", "");
                break;
            case "TVShow":
                dialogFragment = AddTVShowDialogFragment.newInstance("","");
                break;
            default:
                dialogFragment = AddAnimeDialogFragment.newInstance("", "");
                break;
        }

        return dialogFragment;
    }
}
