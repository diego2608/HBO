package com.consorciohbo.app.msdvip.UI.Controls;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.consorciohbo.app.msdvip.BL.BE.AreasMarketingBE;
import com.consorciohbo.app.msdvip.R;

import java.util.ArrayList;

/**
 * Created by Diego on 30/11/15.
 */
public class MarketingArrayAdapter extends ArrayAdapter<AreasMarketingBE> {
    private LayoutInflater inflaterMarketing;
    private Context contextMarketing;
    private ArrayList<AreasMarketingBE> lstareasBEs;

    public MarketingArrayAdapter(Activity contextMarketing, LayoutInflater inflaterMarketing, ArrayList<AreasMarketingBE> lstareasBEs) {
        super(contextMarketing, R.layout.list_single_marketing);
        this.contextMarketing = contextMarketing;
        this.lstareasBEs = lstareasBEs;

    }

    @Override
    public int getCount() {
        if (lstareasBEs == null)
            return 0;
        return lstareasBEs.size();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        View rowView = convertView;
        if (rowView == null){
            //si la vista no existe la creamos
            rowView = inflaterMarketing.inflate(R.layout.list_single_marketing,null);
            holder = new ViewHolder();

            holder.txtvNombreMarketing = (TextView) rowView.findViewById(R.id.txtNombreAreaMarketing);
            holder.imgbRedactar = (ImageButton) rowView.findViewById(R.id.imgbtnRedactar);

            rowView.setTag(holder);
        }else {
            // si ya existe, recuperamos la referencia
            holder = (ViewHolder) rowView.getTag();
        }
        //en este punto, hemos creado la vista o recuperamos la referencia (rowview existe)

        holder.txtvNombreMarketing.setText(lstareasBEs.get(position).getNombreArea());
        //holder.imgbRedactar.setImageDrawable();

        return rowView;
    }

    public class ViewHolder{
        public TextView txtvNombreMarketing;
        public ImageButton imgbRedactar;
    }
}
