package newmediaproject.nmct.howest.be.newmediaproject.BeaconData;

/**
 * Created by Jelle on 2/05/2017.
 */

public interface BeaconContentFactory {
    void getContent(BeaconID beaconID, Callback callback);

    interface Callback {
        void onContentReady(Object content);
    }
}
