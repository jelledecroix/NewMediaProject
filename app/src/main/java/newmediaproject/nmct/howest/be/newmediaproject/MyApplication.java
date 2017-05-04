package newmediaproject.nmct.howest.be.newmediaproject;

import android.app.Application;

import com.estimote.sdk.EstimoteSDK;

/**
 * Created by Jelle on 2/05/2017.
 */


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        EstimoteSDK.initialize(getApplicationContext(), "beaconsnmct-gmail-com-s-yo-0o9", "5de813ae0d14cf65a4ecf423e7a93565");

        // uncomment to enable debug-level logging
        // it's usually only a good idea when troubleshooting issues with the Estimote SDK
//        EstimoteSDK.enableDebugLogging(true);
    }
}
