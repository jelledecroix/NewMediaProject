package newmediaproject.nmct.howest.be.newmediaproject;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ProductAdapter extends ArrayAdapter<Producten> {
    Context mContext;
    int mLayoutResourceId;

    public ProductAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        mContext =context;
        mLayoutResourceId =resource;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        int colors = android.graphics.Color.rgb(232, 94, 0);
        final Producten currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        TextView productNaam = (TextView)row.findViewById(R.id.textProductNaam);
        TextView prijs = (TextView)row.findViewById(R.id.textPrijsDetail);
        TextView invooraad = (TextView)row.findViewById(R.id.textInVoorraad);
        productNaam.setText(currentItem.getmName());
        prijs.setText(Integer.toString( currentItem.getmPrijs()).trim() +" €");
        if (currentItem.getInVooraad() == 1){
            invooraad.setText("invooraad");
        }else{
            invooraad.setText("niet in vooraad");
        }
        if (currentItem.getIsChecked() ==1){
            row.setBackgroundColor(colors);
        }else{
            row.setBackgroundColor(1);
        }
        return row;
    }
}
