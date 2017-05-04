package newmediaproject.nmct.howest.be.newmediaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.estimote.sdk.SystemRequirementsChecker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import newmediaproject.nmct.howest.be.newmediaproject.BeaconData.BeaconID;
import newmediaproject.nmct.howest.be.newmediaproject.BeaconData.EstimoteCloudBeaconDetails;
import newmediaproject.nmct.howest.be.newmediaproject.BeaconData.EstimoteCloudBeaconDetailsFactory;
import newmediaproject.nmct.howest.be.newmediaproject.BeaconData.ProximityContentManager;

public class bdTester extends Activity {
    private ProximityContentManager proximityContentManager;
    private ProductAdapter mAdapter;
     DataBaseAccess dataBaseAccess;
    List<Producten> productenList =new ArrayList<>();
    List<Producten> CategorieProducten = new ArrayList<>();
    EstimoteCloudBeaconDetails beaconDetails;
    ListView listViewBeacons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_tester);
        dataBaseAccess = DataBaseAccess.getInstance(this);
        dataBaseAccess.open();
        List<Beacons> beaconsList= dataBaseAccess.getBeacons();
        productenList = dataBaseAccess.getproducten();
        dataBaseAccess.close();
        List<BeaconID>beaconsids = new ArrayList<>();

        Arrays.asList(beaconsids);
        for(Beacons beacon :beaconsList){

            beaconsids.add( new BeaconID(beacon.getmUUID().trim(),Integer.parseInt(beacon.getmMajor().trim()),Integer.parseInt(beacon.getmMinor().trim())));

        }
        mAdapter =new ProductAdapter(this,R.layout.list_beacons);
         listViewBeacons = (ListView) findViewById(R.id.listViewProd);
        listViewBeacons.setAdapter(mAdapter);
        listViewBeacons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Details(position);
            }
        });
        listViewBeacons.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Producten prodcat =  CategorieProducten.get(position);
                CategorieProducten.clear();
                productenList.clear();
                dataBaseAccess.open();
                dataBaseAccess.addchecked(prodcat);
               productenList = dataBaseAccess.getproducten();
                dataBaseAccess.close();
                if(beaconDetails !=null){

                for(Producten prod:productenList){
                  //  if(beaconDetails.getBeaconMajor()!= null))
                    if(Integer.parseInt(prod.getmCategorie()) == beaconDetails.getBeaconMajor()  ){
                        CategorieProducten.add(prod);
                    }else {
                            CategorieProducten.add(prod);
                    }
                }

                }else {
                    for(Producten prod:productenList){
                        CategorieProducten.add(prod);
                    }
                }
                updateAdapter();


                return true;
            }
        });
        proximityContentManager = new ProximityContentManager(this,beaconsids,
                new EstimoteCloudBeaconDetailsFactory());
        proximityContentManager.setListener(new ProximityContentManager.Listener() {
            @Override
            public void onContentChanged(Object content) {

                UpdateItems(content);
            }
        });



    }

    private void Details(int position){
        Intent i = new Intent(this, Details.class);
      Producten prod =  CategorieProducten.get(position);
        i.putExtra("Product", prod);
        startActivity(i);
    }
    private void UpdateItems(Object content){

        CategorieProducten.clear();
        if (content != null) {
             beaconDetails = (EstimoteCloudBeaconDetails) content;
            setTitle(beaconDetails.getBeaconName());
            for(Producten prod:productenList){
                if(Integer.parseInt(prod.getmCategorie()) == beaconDetails.getBeaconMajor() ){
                    CategorieProducten.add(prod);
                }
            }

        } else {
           setTitle("not in range");
            for(Producten prod:productenList){

                CategorieProducten.add(prod);
            }

        }

        updateAdapter();
    }
    private void updateAdapter(){
        mAdapter.clear();

       // listViewBeacons.getAdapter().notifyDataSetChanged();
        for(Producten prod:CategorieProducten){
            mAdapter.add(prod);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (!SystemRequirementsChecker.checkWithDefaultDialogs(this)) {
        } else {
            proximityContentManager.startContentUpdates();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        proximityContentManager.stopContentUpdates();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        proximityContentManager.destroy();
    }

}
