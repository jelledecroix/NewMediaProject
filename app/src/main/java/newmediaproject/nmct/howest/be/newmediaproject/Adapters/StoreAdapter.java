package newmediaproject.nmct.howest.be.newmediaproject.Adapters;

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

import newmediaproject.nmct.howest.be.newmediaproject.Models.Producten;
import newmediaproject.nmct.howest.be.newmediaproject.Models.Store;
import newmediaproject.nmct.howest.be.newmediaproject.R;

/**
 * Created by jelle on 6/05/2017.
 */

public class StoreAdapter extends ArrayAdapter<Store> {
    Context mContext;
    int mLayoutResourceId;
    public StoreAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        mContext =context;
        mLayoutResourceId =resource;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        int colors = android.graphics.Color.rgb(232, 94, 0);
        final Store currentItem = getItem(position);
        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }
        row.setTag(currentItem);
        TextView storeNaam = (TextView)row.findViewById(R.id.textStoreNaam);
        storeNaam.setText(currentItem.getmName());
        return row;
    }
}
