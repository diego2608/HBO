package com.consorciohbo.app.msdvip.UI.Controls;

/**
 * Created by Diego on 25/11/15.
 */
import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.text.Layout;
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
    private ArrayList<ContactosBE> contactosBEs;

    public ContactoArrayAdapter(Activity context, LayoutInflater inflater, ArrayList<ContactosBE> contactosBEs
                                ) {
        super(context, R.layout.list_single);
        this.context = context;
        this.contactosBEs = contactosBEs;
    }

    @Override
    public int getCount() {
        if(contactosBEs == null)
            return 0;
        return contactosBEs.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        View rowView = view;
        if(rowView == null){
            //si la vista no existe, la creamos
            rowView = inflater.inflate(R.layout.list_single, null);
            holder = new ViewHolder();

            holder.imageView = (ImageView) rowView.findViewById(R.id.imgFotoContacto);
            holder.textView = (TextView) rowView.findViewById(R.id.txtNombreContacto);
            holder.imageButton = (ImageButton) rowView.findViewById(R.id.imageButton);

            rowView.setTag(holder);

        }else{
            //si ya existe, recuperamos la referencia
            holder = (ViewHolder) rowView.getTag();
        }
        //en este punto, o hemos creado la vista o recuperamos la referencia, rowview Existe

        //holder.imageView.setImageDrawable([enviar el recurso de la imagen]);
        holder.textView.setText(contactosBEs.get(position).getNombre());
        //holder.imageButton.setImageDrawable([]);

        return rowView;
    }

    public class ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public ImageButton imageButton;

    }
}