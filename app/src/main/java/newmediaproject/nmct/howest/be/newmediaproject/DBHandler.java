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
    private static final String TABLE_SHOPS = "Producten";
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
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);



    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Beacon Tabel maken
        String CREATE_BEACON_TABLE = "CREATE TABLE"+"TABLE_BEACONS"+"("+KEY_ID +"STRING PRIMARY KEY,"+KEY_NAME+"TEXT,"+KEY_ID +
                KEY_COLOR +"TEXT,"+KEY_GEOLOCATION+"TEXT,"+KEY_UUID+"TEXT,"+KEY_MAJOR+"TEXT,"+KEY_MINOR+"TEXT,"+
                KEY_LOCATION+"TEXT,"+KEY_STOREID+"TEXT"+")";
        db.execSQL(CREATE_BEACON_TABLE);
        //winkel tabel maken
        String CREATE_STORE_TABLE ="CREATE TABLE"+"TABLE_WIKELS"+"("+WINKEL_ID+"STRING PRIMARY KEY,"+WINKEL_NAAM+"TEXT,"+
                WINKEL_LOCATION+"TEXT,"+WINKEL_OPEN +"TEXT"+")";
        db.execSQL(CREATE_STORE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_BEACONS);
        onCreate(db);

    }
    public void AddBeacons (List<Beacons> beacons){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (Beacons beacon:beacons ) {
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
    public Beacons GetBeacon(int id){
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
}
