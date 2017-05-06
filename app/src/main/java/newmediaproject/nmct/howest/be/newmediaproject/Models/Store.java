package newmediaproject.nmct.howest.be.newmediaproject.Models;



import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Store implements Serializable {

    private int mId;

    private String mName;

    private String mLocation;


    public Store(int id,String Name,String Location){
        this.setmId(id);
        this.setmLocation(Location);
        this.setmName(Name);

    }

    public Store() {

    }

    public String toString() {
        return getmName();
    }
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
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

}
