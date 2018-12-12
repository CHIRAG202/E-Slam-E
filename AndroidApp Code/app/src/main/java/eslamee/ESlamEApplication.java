package eslamee;

import android.app.Application;

import eslamee.lib.network.NetworkService;
//import eslamee.sharedActivities.SharedPreferencesManager;


/**
 * Created by cteegarden on 1/26/16.
 */
public class ESlamEApplication extends Application {

    public ESlamEApplication() {

    }


    @Override
    public void onCreate() {
        super.onCreate();

        NetworkService.createInstance(getApplicationContext());

      //  SharedPreferencesManager.createInstance(getApplicationContext());

    }

}