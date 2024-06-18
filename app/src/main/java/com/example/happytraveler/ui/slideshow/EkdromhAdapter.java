package com.example.happytraveler.ui.slideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.happytraveler.R;

import java.util.ArrayList;

public class EkdromhAdapter extends ArrayAdapter<Ekdromh> {

    private Context mContext;
    private int mResource;

    public EkdromhAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Ekdromh> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        TextView taxidiotiko = convertView.findViewById(R.id.taxidiotikografeio);
        TextView xwra = convertView.findViewById(R.id.xwra);
        TextView date = convertView.findViewById(R.id.date);
        TextView price = convertView.findViewById(R.id.price);

        taxidiotiko.setText(getItem(position).getTaxidiotikoGrafeio());
        xwra.setText(getItem(position).getCountry());
        date.setText(getItem(position).getDate());
      //  price.setText(Integer.parseInt(.getPrice()));

        return convertView;
    }
}
