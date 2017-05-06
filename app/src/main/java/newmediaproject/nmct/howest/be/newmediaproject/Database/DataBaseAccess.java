package newmediaproject.nmct.howest.be.newmediaproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import newmediaproject.nmct.howest.be.newmediaproject.Models.Beacons;
import newmediaproject.nmct.howest.be.newmediaproject.Models.Producten;
import newmediaproject.nmct.howest.be.newmediaproject.Models.Store;
import newmediaproject.nmct.howest.be.newmediaproject.Models.StoreProduct;

public class DataBaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DataBaseAccess instance;
    private DataBaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }
    public static DataBaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseAccess(context);
        }
        return instance;
    }
    public  void open() {
        this.database = openHelper.getWritableDatabase();
    }
    public  void close() {
        if (database != null) {
            this.database.close();
        }
    }
    public List<Beacons> getBeacons(){
        List<Beacons> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Beacons",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
        Beacons beacon = new Beacons();
            beacon.setId(cursor.getInt(0));
            beacon.setName(cursor.getString(1));
            beacon.setColor(cursor.getString(2));
            beacon.setmGeoLocation(cursor.getString(3));
            beacon.setmUUID(cursor.getString(4));
            beacon.setmMajor(cursor.getString(5));
            beacon.setmMinor(cursor.getString(6));
            beacon.setmIndoorLocation(cursor.getString(7));
           beacon.setStoreID(cursor.getInt(8));
            list.add(beacon);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

public boolean addchecked(Producten checkProd)
{
    ContentValues prod = new ContentValues();
    prod.put("Id",checkProd.getmId());
    prod.put("name",checkProd.getmName());
    prod.put("prijs",checkProd.getmPrijs());
    prod.put("Categorie",checkProd.getmCategorie());
    prod.put("inVooraad",checkProd.getInVooraad());
    if(checkProd.getIsChecked()==1) {
        prod.put("IsChecked",0);
    }else {
        prod.put("IsChecked",1);
    }

    return database.update("Producten",prod,"id="+checkProd.getmId(),null) >0;
}


    public List<Producten>getproducten(){
        List<Producten>productenList=new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Producten",null);
        while(!cursor.isLast()) {
            cursor.moveToNext();
            Producten product = new Producten();
            product.setmId(cursor.getInt(0));
            product.setmName(cursor.getString(1));
            product.setmPrijs(cursor.getInt(2));
            product.setmCategorie(cursor.getString(3));
            product.setInVooraad(cursor.getInt(4));
           product.setIsChecked(cursor.getInt(5));
            productenList.add(product);
        }
        cursor.close();
        return productenList;
    }
    public List<Producten>getproducten(Store winkels ){
        List<Producten>productenList=new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT Producten .Id, name, StoreProduct.prijs ,Categorie,invooraad,IsChecked FROM Producten INNER JOIN StoreProduct ON Producten.Id =  StoreProduct.ProductId WHERE StoreId ="+winkels.getmId(),null);
        while(!cursor.isLast()) {
            cursor.moveToNext();
            Producten product = new Producten();
            product.setmId(cursor.getInt(0));
            product.setmName(cursor.getString(1));
            product.setmPrijs(cursor.getInt(2));
            product.setmCategorie(cursor.getString(3));
            product.setInVooraad(cursor.getInt(4));
            product.setIsChecked(cursor.getInt(5));
            productenList.add(product);
        }
        cursor.close();

        return productenList;
    }

    public List<StoreProduct>getStoreProducts(){
        List<StoreProduct>StoreProductList=new ArrayList<>();
        String selectQuery="SELECT * FROM StoreProduct";
        Cursor cursor = database.rawQuery(selectQuery,null);
        while(!cursor.isLast()) {
            cursor.moveToNext();
                StoreProduct storeproduct=new StoreProduct();
                storeproduct.setmId(cursor.getString(0));
                storeproduct.setmmStoreId(cursor.getString(1));
                storeproduct.setmProductId(cursor.getString(2));
                storeproduct.setmPrijs( cursor.getInt(3));
                StoreProductList.add(storeproduct);

        }

        cursor.close();
        return StoreProductList;
    }
    public List<StoreProduct>getStoreProducts(Store winkel){
        List<StoreProduct>StoreProductList=new ArrayList<>();
        String selectQuery="SELECT * FROM StoreProduct WHERE StoreId = "+ winkel.getmId();
        Cursor cursor = database.rawQuery(selectQuery,null);

        while(!cursor.isLast()) {
            cursor.moveToNext();
            StoreProduct storeproduct=new StoreProduct();
            storeproduct.setmId(cursor.getString(0));
            storeproduct.setmmStoreId(cursor.getString(1));
            storeproduct.setmProductId(cursor.getString(2));
            storeproduct.setmPrijs( cursor.getInt(3));
            StoreProductList.add(storeproduct);

        }

        cursor.close();
        return StoreProductList;
    }
    public List<Store>getStores(){
        List<Store>storelist=new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Store",null);
        while (!cursor.isLast()){
            cursor.moveToNext();
            Store store=new Store();
            store.setmId(cursor.getInt(0));
            store.setmName(cursor.getString(1));
            store.setmLocation(cursor.getString(2));
            storelist.add(store);
        }

        cursor.close();
        return storelist;
    }
}
