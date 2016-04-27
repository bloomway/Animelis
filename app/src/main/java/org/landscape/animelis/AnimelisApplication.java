package org.landscape.animelis;

import android.app.Application;

//import com.firebase.client.Firebase;

/**
 * Created by Chatofrey on 17/04/2016.
 * chatofrey@gmail.com
 */
public class AnimelisApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       /* Firebase.setAndroidContext(this);*/
    }
}
