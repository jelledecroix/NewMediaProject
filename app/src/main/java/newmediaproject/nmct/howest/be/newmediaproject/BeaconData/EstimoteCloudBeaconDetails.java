package newmediaproject.nmct.howest.be.newmediaproject.BeaconData;

import com.estimote.sdk.cloud.model.Color;

/**
 * Created by Jelle on 2/05/2017.
 */

public class EstimoteCloudBeaconDetails {

    private String beaconName;
    private Color beaconColor;
    private Integer beaconMajor;
    private Integer beaconMinor;

    public EstimoteCloudBeaconDetails(String beaconName, Color beaconColor,int major,int minor) {
        this.beaconName = beaconName;
        this.beaconColor = beaconColor;
        this.beaconMajor =major;
        this.beaconMinor =minor;
    }

    public String getBeaconName() {
        return beaconName;
    }

    public Color getBeaconColor() {
        return beaconColor;
    }

    @Override
    public String toString() {
        return "[beaconName: " + getBeaconName() + ", beaconColor: " + getBeaconColor() + "]";
    }

    public Integer getBeaconMajor() {
        return beaconMajor;
    }

    public Integer getBeaconMinor() {
        return beaconMinor;
    }
}
