package newmediaproject.nmct.howest.be.newmediaproject;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;


public class Details extends Activity {
    Producten gekozenProduct ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
         gekozenProduct = (Producten)i.getSerializableExtra("Product");
        TextView naam = (TextView) findViewById(R.id.textProductDetailNaam);
        naam.setText(gekozenProduct.getmName());
        TextView prijs = (TextView) findViewById(R.id.textPrijsDetail);
        prijs.setText(gekozenProduct.getmPrijs()+ " €");
    }
}
