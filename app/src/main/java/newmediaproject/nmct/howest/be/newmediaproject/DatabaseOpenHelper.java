package newmediaproject.nmct.howest.be.newmediaproject;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by jelle on 21/04/2017.
 */

    public class DatabaseOpenHelper extends SQLiteAssetHelper {
        private static final String DATABASE_NAME = "Beacons.db";
        private static final int DATABASE_VERSION = 1;

        public DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
}
