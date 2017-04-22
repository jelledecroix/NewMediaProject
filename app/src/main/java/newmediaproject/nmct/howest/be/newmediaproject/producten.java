package newmediaproject.nmct.howest.be.newmediaproject;

/**
 * Created by Jelle on 18/04/2017.
 */

public class Producten {
    @com.google.gson.annotations.SerializedName("id")
    private int mId;
    @com.google.gson.annotations.SerializedName("name")
    private String mName;

public Producten(int id, String naam){
    this.setmId(id);
    this.setmName(naam);
}

    public Producten() {

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
}
