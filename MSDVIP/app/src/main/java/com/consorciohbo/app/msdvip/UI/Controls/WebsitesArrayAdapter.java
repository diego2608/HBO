package com.consorciohbo.app.msdvip.UI.Controls;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.consorciohbo.app.msdvip.BL.BE.WebsitesBE;
import com.consorciohbo.app.msdvip.R;

import java.util.ArrayList;

/**
 * Created by Diego on 1/12/15.
 */
public class WebsitesArrayAdapter extends ArrayAdapter<WebsitesBE> {
    private LayoutInflater inflaterWebsite;
    private Context contextWebsite;
    private ArrayList<WebsitesBE> lstWebsitesBEs;

    public WebsitesArrayAdapter(Activity contextWebsite, LayoutInflater inflaterWebsite, ArrayList<WebsitesBE> lstWebsitesBEs) {
        super(contextWebsite, R.layout.row_website);
        this.contextWebsite = contextWebsite;
        this.lstWebsitesBEs = lstWebsitesBEs;
    }

    @Override
    public int getCount() {
        if (lstWebsitesBEs == null)
            return 0;

        return lstWebsitesBEs.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        View rowView = convertView;

        if (rowView == null) {
            rowView = inflaterWebsite.inflate(R.layout.row_website, null);
            holder = new ViewHolder();

            holder.txtvUrlWebsite = (TextView) rowView.findViewById(R.id.txturlPagina);
            holder.txtvVermas = (TextView) rowView.findViewById(R.id.txtVerMas);

            rowView.setTag(holder);
        }else{
            holder = (ViewHolder) rowView.getTag();
        }
        holder.txtvUrlWebsite.setText(lstWebsitesBEs.get(position).getUrlWebsite());
        holder.txtvVermas.setText("Ver mas");

        return rowView;
    }

    public class ViewHolder {
        public TextView txtvUrlWebsite;
        public TextView txtvVermas;
    }
}
