package newmediaproject.nmct.howest.be.newmediaproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class bdTester extends Activity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_tester);
        listView = (ListView) findViewById(R.id.listView);
        DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance(this);
        dataBaseAccess.open();
        List<StoreProduct> storeproducts = dataBaseAccess.getStoreProducts();
        List<Store>store = dataBaseAccess.getStores();
        List<Beacons> beacon= dataBaseAccess.getBeacons();
        List<Producten> producten = dataBaseAccess.getproducten();
        List<String> namen = new ArrayList<>();
        dataBaseAccess.close();

    }
}
