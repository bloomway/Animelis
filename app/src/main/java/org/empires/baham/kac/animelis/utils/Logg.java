package org.empires.baham.kac.animelis.utils;

import android.util.Log;

/**
 * Created by Chatofrey on 22/05/2016.
 * chatofrey@gmail.com
 * Animelis
 */
public class Logg {
    public static final int d(String tag, String message) {
        return android.util.Log.d(tag, ">> " + message);
    }

    public static final int i(String tag, String message) {
        return android.util.Log.i(tag, ">> " + message);
    }

    public static final int w(String tag, String message) {
        return android.util.Log.w(tag, ">> " + message);
    }

    public static final int e(String tag, String message) {
        return android.util.Log.e(tag, ">> " + message);
    }
}
