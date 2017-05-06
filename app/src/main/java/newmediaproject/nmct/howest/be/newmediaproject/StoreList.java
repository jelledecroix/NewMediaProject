package newmediaproject.nmct.howest.be.newmediaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import newmediaproject.nmct.howest.be.newmediaproject.Adapters.ProductAdapter;
import newmediaproject.nmct.howest.be.newmediaproject.Adapters.StoreAdapter;
import newmediaproject.nmct.howest.be.newmediaproject.Database.DataBaseAccess;
import newmediaproject.nmct.howest.be.newmediaproject.Models.Producten;
import newmediaproject.nmct.howest.be.newmediaproject.Models.Store;

public class StoreList extends Activity {
    List<Store>winkels = new ArrayList<>();
    DataBaseAccess dataBaseAccess;
    ListView listViewStore;
    private StoreAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
        dataBaseAccess = DataBaseAccess.getInstance(this);
        dataBaseAccess.open();
        winkels= dataBaseAccess.getStores();
        dataBaseAccess.close();
        mAdapter =new StoreAdapter(this,R.layout.strore_list);
        listViewStore = (ListView) findViewById(R.id.listViewstore);
        listViewStore.setAdapter(mAdapter);
        listViewStore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Producten(position);
            }
        });
        updateAdapter();
    }
    private void updateAdapter(){
        mAdapter.clear();
        // listViewBeacons.getAdapter().notifyDataSetChanged();
        for(Store winkel:winkels){
            mAdapter.add(winkel);
        }
    }
    private void Producten(int position){
        Intent i = new Intent(this,ProductLijst.class);
        Store store = winkels.get(position);
        i.putExtra("GekozenWinkel", store);
        startActivity(i);
    }
}
