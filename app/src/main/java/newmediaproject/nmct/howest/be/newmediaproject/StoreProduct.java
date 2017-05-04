package newmediaproject.nmct.howest.be.newmediaproject;

/**
 * Created by Jelle on 18/04/2017.
 */

public class StoreProduct {

    private String mId;

    private String mStoreId;

    private String mProductId;

    private int mPrijs;
        public StoreProduct(String id,String storeid,String productid,int prijs){
           this.setmId(id);
            this.setmPrijs(prijs);
            this.setmProductId(productid);
            this.setmmStoreId(storeid);

        }

    public StoreProduct() {

    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmmStoreId() {
        return mStoreId;
    }

    public void setmmStoreId(String mmStoreId) {
        this.mStoreId = mmStoreId;
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
