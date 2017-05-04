package newmediaproject.nmct.howest.be.newmediaproject.BeaconData;

import android.util.Log;

import com.estimote.sdk.cloud.CloudCallback;
import com.estimote.sdk.cloud.EstimoteCloud;
import com.estimote.sdk.cloud.model.BeaconInfo;
import com.estimote.sdk.cloud.model.Color;
import com.estimote.sdk.exception.EstimoteServerException;

/**
 * Created by Jelle on 2/05/2017.
 */

public class EstimoteCloudBeaconDetailsFactory implements BeaconContentFactory {

    private static final String TAG = "BeaconDetailsFactory";

    @Override
    public void getContent(final BeaconID beaconID, final Callback callback) {
        EstimoteCloud.getInstance().fetchBeaconDetails(
                beaconID.getProximityUUID(), beaconID.getMajor(), beaconID.getMinor(),
                new CloudCallback<BeaconInfo>() {

                    @Override
                    public void success(BeaconInfo beaconInfo) {
                        callback.onContentReady(new EstimoteCloudBeaconDetails(
                                beaconInfo.name, beaconInfo.color,beaconInfo.major,beaconInfo.minor));
                    }

                    @Override
                    public void failure(EstimoteServerException e) {
                        Log.e(TAG, "Couldn't fetch data from Estimote Cloud for beacon " + beaconID
                                + ", will use default values instead. Double-check if the app ID and app "
                                + "token provided in the MyApplication are correct, and if the beacon with "
                                + "such ID is assigned to your Estimote Account. The error was: "
                                + e.toString());
                        callback.onContentReady(new EstimoteCloudBeaconDetails("beacon", Color.UNKNOWN,0,0));
                    }
                });
    }
}