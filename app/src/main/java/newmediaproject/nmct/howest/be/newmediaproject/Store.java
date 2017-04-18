package newmediaproject.nmct.howest.be.newmediaproject;

import com.google.gson.internal.ConstructorConstructor;

import java.lang.reflect.Constructor;

public class Store {
    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    @com.google.gson.annotations.SerializedName("name")
    private String mName;
    @com.google.gson.annotations.SerializedName("location")
    private String mLocation;
    @com.google.gson.annotations.SerializedName("open")
    private String mOpen;

    public Store(String id,String Name,String Location,String Open){
        this.setmId(id);
        this.setmLocation(Location);
        this.setmName(Name);
        this.setmOpen(Open);
    }
    public String toString() {
        return getmName();
    }
    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmOpen() {
        return mOpen;
    }

    public void setmOpen(String mOpen) {
        this.mOpen = mOpen;
    }
}
