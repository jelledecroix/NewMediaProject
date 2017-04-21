package newmediaproject.nmct.howest.be.newmediaproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jelle on 21/04/2017.
 */

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
    public List<Beacons> GetBeacons(){
List<Beacons> list = new ArrayList<>();
return list;
    }
}
