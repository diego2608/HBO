package com.consorciohbo.app.msdvip.UI.Controls;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.consorciohbo.app.msdvip.BL.BE.MaterialesBE;
import com.consorciohbo.app.msdvip.R;

import java.util.ArrayList;

/**
 * Created by Diego on 3/12/15.
 */
public class MaterialesDescargadosArrayAdapter extends ArrayAdapter<MaterialesBE> {
    private LayoutInflater inflaterMaterialesDescargados;
    private Context contextMaterialesDescargados;
    private ArrayList<MaterialesBE> lstMaterialesDescargadosBE;

    public MaterialesDescargadosArrayAdapter(Activity contextMaterialesDescargados, LayoutInflater inflaterMaterialesDescargados, ArrayList<MaterialesBE> lstMaterialesDescargadosBE) {
        super(contextMaterialesDescargados, R.layout.list_single_material_descargado);

        this.contextMaterialesDescargados = contextMaterialesDescargados;
        this.lstMaterialesDescargadosBE = lstMaterialesDescargadosBE;

    }

    @Override
    public int getCount() {
        if (lstMaterialesDescargadosBE == null)
            return 0;
        return lstMaterialesDescargadosBE.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        View rowView = convertView;

        if (rowView == null){

            rowView = inflaterMaterialesDescargados.inflate(R.layout.list_single_material_descargado,null);
            holder = new ViewHolder();

            holder.txtNombreMaterialDescargado = (TextView) rowView.findViewById(R.id.txtvMaterialDescargado);
            holder.txtDescripcionMaterialDescargado = (TextView) rowView.findViewById(R.id.txtvDescripcionMaterialDescargado);
            holder.imgvMaterialDescargado = (ImageView) rowView.findViewById(R.id.imgvMaterialDescargado);
            holder.btnVerMaterial = (Button) rowView.findViewById(R.id.btnVerMaterial);

            rowView.setTag(holder);
        }else{
            holder = (ViewHolder) rowView.getTag();
        }

        holder.txtNombreMaterialDescargado.setText(lstMaterialesDescargadosBE.get(position).getNombreMaterial());
        holder.txtDescripcionMaterialDescargado.setText(lstMaterialesDescargadosBE.get(position).getDescripcion());
        holder.btnVerMaterial.setText("Descargar");
        //holder.imgvMaterialDescargado.setImageDrawable();


        return rowView;
    }

    public class ViewHolder{
        public TextView txtNombreMaterialDescargado;
        public TextView txtDescripcionMaterialDescargado;
        public ImageView imgvMaterialDescargado;
        public Button btnVerMaterial;
    }
}
