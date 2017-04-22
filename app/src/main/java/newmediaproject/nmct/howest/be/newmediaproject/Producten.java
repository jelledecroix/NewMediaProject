package newmediaproject.nmct.howest.be.newmediaproject;

/**
 * Created by Jelle on 18/04/2017.
 */

public class Producten {
    @com.google.gson.annotations.SerializedName("id")
    private int mId;
    @com.google.gson.annotations.SerializedName("name")
    private String mName;

<<<<<<< HEAD:app/src/main/java/newmediaproject/nmct/howest/be/newmediaproject/producten.java
public Producten(int id, String naam){
=======
public Producten(String id, String naam){
>>>>>>> 9c04804918de256da30175610b3d3f00d4c42e41:app/src/main/java/newmediaproject/nmct/howest/be/newmediaproject/Producten.java
    this.setmId(id);
    this.setmName(naam);
}

    public Producten() {

    }

<<<<<<< HEAD:app/src/main/java/newmediaproject/nmct/howest/be/newmediaproject/producten.java
    public int getmId() {
=======
    public String getmId() {
>>>>>>> 9c04804918de256da30175610b3d3f00d4c42e41:app/src/main/java/newmediaproject/nmct/howest/be/newmediaproject/Producten.java
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
}
