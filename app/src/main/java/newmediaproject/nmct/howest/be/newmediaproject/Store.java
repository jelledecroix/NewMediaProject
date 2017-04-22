package newmediaproject.nmct.howest.be.newmediaproject;

import com.google.gson.internal.ConstructorConstructor;

import java.lang.reflect.Constructor;

public class Store {
    @com.google.gson.annotations.SerializedName("id")
    private int mId;
    @com.google.gson.annotations.SerializedName("name")
    private String mName;
    @com.google.gson.annotations.SerializedName("location")
    private String mLocation;


    public Store(int id,String Name,String Location){
        this.setmId(id);
        this.setmLocation(Location);
        this.setmName(Name);

    }

    public Store() {

    }

<<<<<<< HEAD
=======
    public Store() {

    }

>>>>>>> 9c04804918de256da30175610b3d3f00d4c42e41
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
