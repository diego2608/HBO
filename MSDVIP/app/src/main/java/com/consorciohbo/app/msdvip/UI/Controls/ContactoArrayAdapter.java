package com.consorciohbo.app.msdvip.UI.Controls;

/**
 * Created by Diego on 25/11/15.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.consorciohbo.app.msdvip.BL.BE.ContactosBE;
import com.consorciohbo.app.msdvip.R;

import java.util.ArrayList;


public class ContactoArrayAdapter extends ArrayAdapter<ContactosBE>{
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ContactosBE> lstcontactosBEs;

    public ContactoArrayAdapter(Activity context, LayoutInflater inflater, ArrayList<ContactosBE> lstcontactosBEs
                                ) {
        super(context, R.layout.list_single_contacto);
        this.context = context;
        this.lstcontactosBEs = lstcontactosBEs;
    }

    @Override
    public int getCount() {
        if(lstcontactosBEs == null)
            return 0;
        return lstcontactosBEs.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        View rowView = view;
        if(rowView == null){
            //si la vista no existe, la creamos
            rowView = inflater.inflate(R.layout.list_single_contacto, null);
            holder = new ViewHolder();

            holder.imgContacto = (ImageView) rowView.findViewById(R.id.imgFotoContacto);
            holder.txtNombreContacto = (TextView) rowView.findViewById(R.id.txtNombreContacto);
            holder.imgbRedactar = (ImageButton) rowView.findViewById(R.id.imageButton);

            rowView.setTag(holder);

        }else{
            //si ya existe, recuperamos la referencia
            holder = (ViewHolder) rowView.getTag();
        }
        //en este punto, o hemos creado la vista o recuperamos la referencia, rowview Existe

        //holder.imgContacto.setImageDrawable([enviar el recurso de la imagen]);
        holder.txtNombreContacto.setText(lstcontactosBEs.get(position).getNombre());
        //holder.imgbRedactar.setImageDrawable([]);

        return rowView;
    }

    public class ViewHolder{
        public ImageView imgContacto;
        public TextView txtNombreContacto;
        public ImageButton imgbRedactar;

    }
}