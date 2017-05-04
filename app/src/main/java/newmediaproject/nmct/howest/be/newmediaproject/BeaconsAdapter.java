package newmediaproject.nmct.howest.be.newmediaproject;

import android.app.Activity;
import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


public class BeaconsAdapter extends ArrayAdapter<Beacons> {
    Context mContext;

    int mLayoutResourceId;

    public BeaconsAdapter(Context context,  int resource) {
        super(context, resource);

        mContext = context;
        mLayoutResourceId = resource;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        final Beacons currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);

        TextView beaconnamm = (TextView) row.findViewById(R.id.textProductNaam);
        beaconnamm.setText(currentItem.getmName());
        ImageView beaconKleur = (ImageView) row.findViewById(R.id.imageviewBeaonc);
        beaconKleur.setImageResource(ColorHelper.getResourceId(currentItem.getColor()));
        return row;
    }
}

