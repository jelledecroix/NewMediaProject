package newmediaproject.nmct.howest.be.newmediaproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "OfflineStore";
    //  table names
    private static final String TABLE_BEACONS = "Beacons";
    private static final String TABLE_WIKELS = "Winkels";
    private static final String TABLE_PRODUCTEN= "Producten";
    private static final String TABLE_STOREPRODUCT="StoreProduct";
    //Beacons TableCollums
    private static  final String KEY_ID ="Id";
    private static  final String KEY_NAME ="Name";
    private static  final String KEY_COLOR ="Color";
    private static  final String KEY_GEOLOCATION ="GeoLocation";
    private static  final String KEY_UUID ="UUID";
    private static  final String KEY_MAJOR ="Major";
    private static  final String KEY_MINOR ="MINOR";
    private static  final String KEY_LOCATION ="Location";
    private static  final String KEY_STOREID ="StoreID";
    //Store TableCollums
    private static  final String WINKEL_ID="Id";
    private static final String WINKEL_NAAM="Naam";
    private static final String WINKEL_LOCATION="Localtion";
    private static final String WINKEL_OPEN ="Open";
    //Product TableCollums
    private static final String PRODUCT_ID="Id";
    private static final String PRODUCT_NAME="Name";
    //StoreProduct TableCollums
    private static final String STOREPRODUCT_ID="Id";
    private static final String STOREPRODUCT_STOREID="StoreId";
    private static final String STOREPRODUCT_PRODUCTID="ProductId";
    private static final String STOREPRODUCT_PRIJS="Prijs";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Beacon Tabel maken
        String CREATE_BEACON_TABLE = "CREATE TABLE IF NOT EXISTS"+"TABLE_BEACONS"+"("+KEY_ID +"STRING PRIMARY KEY,"+KEY_NAME+"TEXT,"+KEY_ID +
                KEY_COLOR +"TEXT,"+KEY_GEOLOCATION+"TEXT,"+KEY_UUID+"TEXT,"+KEY_MAJOR+"TEXT,"+KEY_MINOR+"TEXT,"+
                KEY_LOCATION+"TEXT,"+KEY_STOREID+"TEXT"+");";
        db.execSQL(CREATE_BEACON_TABLE);
        //winkel tabel maken
        String CREATE_STORE_TABLE ="CREATE TABLE IF NOT EXISTS"+"TABLE_WIKELS"+"("+WINKEL_ID+" STRING PRIMARY KEY,"+WINKEL_NAAM+" TEXT,"+
                WINKEL_LOCATION+" TEXT,"+WINKEL_OPEN +" TEXT"+");";
        db.execSQL(CREATE_STORE_TABLE);
        //Producten tabel maken
        String CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS"+"TABLE_PRODUCTEN"+"("+PRODUCT_ID+" STRING PRIMARY KEY,"+PRODUCT_NAME+" TEXT,"+");";
        db.execSQL(CREATE_PRODUCT_TABLE);
        //Store Producten tabel maken
        String CREATE_STOREPRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS"+"TABE_STOREPRODUCT"+"("+STOREPRODUCT_ID+" STRING PRIMARY KEY,"+STOREPRODUCT_STOREID+" TEXT,"+STOREPRODUCT_PRODUCTID+" TEXT,"+STOREPRODUCT_PRIJS+" DOUBLE(15)"+");";
        db.execSQL(CREATE_STOREPRODUCT_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_BEACONS);
        onCreate(db);

    }
//product functies
    public void addProducten (List<Producten> producten){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (Producten product:producten ) {
            Producten prod = GetProduct(product.getmId());
            if(prod != null){
            values.put(PRODUCT_ID,product.getmId());
            values.put(PRODUCT_NAME,product.getmName());
            db.insert(TABLE_PRODUCTEN,null,values);
            db.close();
            }
        }
    }

    public Producten GetProduct(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_PRODUCTEN ,
                new String[]{PRODUCT_ID, PRODUCT_NAME },PRODUCT_ID +
                        "=?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor !=null)
            cursor.moveToFirst();

        Producten product = new Producten(cursor.getString(0),cursor.getString(1));


        db.close();
        cursor.close();
        return product;
    }
    public List<Producten>getproducten(){
        List<Producten>productenList=new ArrayList<>();

        String selectQuery="SELECT * FROM"+TABLE_PRODUCTEN;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Producten product=new Producten();
                product.setmId(cursor.getString(0));
                product.setmName(cursor.getString(1));

                productenList.add(product);
            }
            while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return productenList;
    }
// beacon Functies
    public void AddBeacons (List<Beacons> beacons){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (Beacons beacon:beacons ) {
            Beacons bea = GetBeacon(beacon.getId());
            if(bea != null){
            values.put(KEY_ID,beacon.getId());
            values.put(KEY_NAME,beacon.getmName());
            values.put(KEY_COLOR,beacon.getColor());
            values.put(KEY_GEOLOCATION,beacon.getmGeoLocation());
            values.put(KEY_UUID,beacon.getmUUID());
            values.put(KEY_MAJOR,beacon.getmMajor());
            values.put(KEY_MINOR,beacon.getmMinor());
            values.put(KEY_LOCATION,beacon.getmIndoorLocation());
            values.put(KEY_STOREID,beacon.getStoreID());

            db.insert(TABLE_BEACONS,null,values);
            db.close();
        }
        }
    }
    public Beacons GetBeacon(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_BEACONS ,
                new String[]{KEY_ID, KEY_COLOR , KEY_GEOLOCATION , KEY_UUID,
                        KEY_MAJOR, KEY_MINOR ,KEY_LOCATION, KEY_STOREID},KEY_ID +
                        "=?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor !=null)
            cursor.moveToFirst();

        Beacons beacon = new Beacons(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));


        db.close();
        cursor.close();
        return beacon;
    }
    public List<Beacons>getBeacons(){
        List<Beacons>beaconList=new ArrayList<>();

        String selectQuery="SELECT * FROM"+TABLE_BEACONS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Beacons beacon=new Beacons();
                beacon.setId(cursor.getString(0));
                beacon.setName(cursor.getString(1));
                beacon.setColor(cursor.getString(2));
                beacon.setmGeoLocation( cursor.getString(3));
                beacon.setmUUID(cursor.getString(4));
                beacon.setmMajor(cursor.getString(5));
                beacon.setmMinor(cursor.getString(6));
                beacon.setmIndoorLocation(cursor.getString(8));
                beacon.setStoreID(cursor.getString(9));
                beaconList.add(beacon);
            }
            while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return beaconList;
    }
    //STore Product Functies
    public void AddStoreProduct (List<StoreProduct> storeProductlijst){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (StoreProduct storeproduct:storeProductlijst ) {
            StoreProduct st = GetStoreProduct(storeproduct.getmmStoreId(),storeproduct.getmProductId());
            if(st != null){
                values.put(STOREPRODUCT_ID,storeproduct.getmId());
                values.put(STOREPRODUCT_STOREID,storeproduct.getmmStoreId());
                values.put(STOREPRODUCT_PRODUCTID,storeproduct.getmProductId());
                values.put(STOREPRODUCT_PRIJS,storeproduct.getmPrijs());
                db.insert(TABLE_STOREPRODUCT,null,values);
                db.close();
            }
        }
    }
    public List<StoreProduct>getStoreProducts(){
        List<StoreProduct>StoreProductList=new ArrayList<>();
        String selectQuery="SELECT * FROM"+TABLE_STOREPRODUCT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                StoreProduct storeproduct=new StoreProduct();
                storeproduct.setmId(cursor.getString(0));
                storeproduct.setmmStoreId(cursor.getString(1));
                storeproduct.setmProductId(cursor.getString(2));
                storeproduct.setmPrijs( cursor.getInt(3));
                StoreProductList.add(storeproduct);
            }
            while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return StoreProductList;
    }
    public StoreProduct GetStoreProduct(String winkelid,String productid){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c  = db.rawQuery("SELECT * FROM "+ TABLE_STOREPRODUCT + " WHERE STOREPRODUCT_STOREID =? AND STOREPRODUCT_PRODUCTID =?",new String[]{winkelid,productid});
        StoreProduct storeproduct = new StoreProduct(c.getString(0),c.getString(1),c.getString(2),c.getInt(3));
        return storeproduct;
    }
    //store functies
    public void AddStore (List<Store> storelijst){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (Store store:storelijst ) {
            Store st = GetStore(store.getmId());
            if(st != null){
            values.put(WINKEL_ID,store.getmId());
            values.put(WINKEL_NAAM,store.getmName());
            values.put(WINKEL_LOCATION,store.getmLocation());
            values.put(WINKEL_OPEN,store.getmOpen());


            db.insert(TABLE_WIKELS,null,values);
            db.close();
        }
        }
    }
    public List<Store>getStores(){
        List<Store>storelist=new ArrayList<>();

        String selectQuery="SELECT * FROM"+TABLE_BEACONS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Store store=new Store();
                store.setmId(cursor.getString(0));
                store.setmName(cursor.getString(1));
                store.setmLocation(cursor.getString(2));
                store.setmOpen( cursor.getString(3));
                storelist.add(store);
            }
            while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return storelist;
    }
    public Store GetStore(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_BEACONS ,
                new String[]{WINKEL_ID, WINKEL_NAAM , WINKEL_LOCATION , WINKEL_OPEN},
                WINKEL_ID +
                        "=?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor !=null)
            cursor.moveToFirst();

        Store store = new Store(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        db.close();
        cursor.close();
        return store;
    }
}
