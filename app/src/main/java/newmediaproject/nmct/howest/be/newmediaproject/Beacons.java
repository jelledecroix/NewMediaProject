package newmediaproject.nmct.howest.be.newmediaproject;
//een beaconLijst Maken
public class Beacons  {

    /**
     * Item text
     */


    private String mName;

    private String Color;

    private String mGeoLocation;

    private String mUUID;

    private String mMajor;

    private String mMinor;

    private String mIndoorLocation;

    private int mId;
    private  int StoreID;


    /**
     * ToDoItem constructor
     */
    public Beacons() {

    }

    @Override
    public String toString() {
        return getmName();
    }

    /**
     * Initializes a new ToDoItem
     *

     *            The item text
     * @param id
     *            The item id
     */
    public Beacons(int id,String name,String color,String GeoLocation,String uuid,String major,String minor,String indoorlocation,int StoreID) {
        this.setName(name);
        this.setColor(color);
        this.setmGeoLocation(GeoLocation);
        this.setmUUID(uuid);
        this.setmMajor(major);
        this.setmMinor(minor);
        this.setmIndoorLocation(indoorlocation);
        this.setId(id);
        this.setStoreID(StoreID);
    }




    /**
     * Sets the item text
     *
     * @param text
     *            text to set
     */


    /**
     * Returns the item id
     */
    public int getId() {
        return mId;
    }

    /**
     * Sets the item id
     *
     * @param id
     *            id to set
     */
    public final void setId(int id) {
        mId = id;
    }


    @Override
    public boolean equals(Object o) {
        return o instanceof Beacons && ((Beacons) o).mId == mId;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setmGeoLocation(String mGeoLocation) {
        this.mGeoLocation = mGeoLocation;
    }

    public void setmUUID(String mUUID) {
        this.mUUID = mUUID;
    }

    public void setmMajor(String mMajor) {
        this.mMajor = mMajor;
    }

    public void setmMinor(String mMinor) {
        this.mMinor = mMinor;
    }

    public void setmIndoorLocation(String mIndoorLocation) {
        this.mIndoorLocation = mIndoorLocation;
    }

    public String getmName() {
        return mName;
    }

    public String getColor() {
        return Color;
    }

    public String getmGeoLocation() {
        return mGeoLocation;
    }

    public String getmUUID() {
        return mUUID;
    }

    public String getmMajor() {
        return mMajor;
    }

    public String getmMinor() {
        return mMinor;
    }

    public String getmIndoorLocation() {
        return mIndoorLocation;
    }

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int storeID) {
        StoreID = storeID;
    }
}
