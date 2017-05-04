package newmediaproject.nmct.howest.be.newmediaproject.BeaconData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jelle on 2/05/2017.
 */


public class BeaconContentCache implements BeaconContentFactory {

    private BeaconContentFactory beaconContentFactory;

    private Map<BeaconID, Object> cachedContent = new HashMap<>();

    public BeaconContentCache(BeaconContentFactory beaconContentFactory) {
        this.beaconContentFactory = beaconContentFactory;
    }

    @Override
    public void getContent(final BeaconID beaconID, final Callback callback) {
        if (cachedContent.containsKey(beaconID)) {
            callback.onContentReady(cachedContent.get(beaconID));
        } else {
            beaconContentFactory.getContent(beaconID, new Callback() {
                @Override
                public void onContentReady(Object content) {
                    cachedContent.put(beaconID, content);
                    callback.onContentReady(content);
                }
            });
        }
    }
}