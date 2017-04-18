package newmediaproject.nmct.howest.be.newmediaproject;

/**
 * Created by Jelle on 18/04/2017.
 */

public class StoreProduct {
    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    @com.google.gson.annotations.SerializedName("stroreid")
    private String mStroreId;
    @com.google.gson.annotations.SerializedName("productid")
    private String mProductId;
    @com.google.gson.annotations.SerializedName("prijs")
    private int mPrijs;
        public StoreProduct(String id,String storeid,String productid,int prijs){
           this.setmId(id);
            this.setmPrijs(prijs);
            this.setmProductId(productid);
            this.setmStroreId(storeid);

        }
    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmStroreId() {
        return mStroreId;
    }

    public void setmStroreId(String mStroreId) {
        this.mStroreId = mStroreId;
    }

    public String getmProductId() {
        return mProductId;
    }

    public void setmProductId(String mProductId) {
        this.mProductId = mProductId;
    }

    public int getmPrijs() {
        return mPrijs;
    }

    public void setmPrijs(int mPrijs) {
        this.mPrijs = mPrijs;
    }
}
