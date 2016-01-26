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
public class MaterialesNoDescargadosArrayAdapter extends ArrayAdapter<MaterialesBE> {
    private LayoutInflater inflaterMaterialNoDescargado;
    private Context contextMaterialDescargado;
    private ArrayList<MaterialesBE> lstMaterialesNoDescargadosBE;

    public MaterialesNoDescargadosArrayAdapter(Activity contextMaterialDescargado, LayoutInflater inflaterMaterialNoDescargado, ArrayList<MaterialesBE> lstMaterialesNoDescargadosBE) {
        super(contextMaterialDescargado, R.layout.list_single_material_nodescargado);
        this.contextMaterialDescargado = contextMaterialDescargado;
        this.lstMaterialesNoDescargadosBE = lstMaterialesNoDescargadosBE;
        this.inflaterMaterialNoDescargado = inflaterMaterialNoDescargado;

    }

    @Override
    public int getCount() {
        if (lstMaterialesNoDescargadosBE == null)
            return 0;
        return lstMaterialesNoDescargadosBE.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        View rowView = convertView;
        if (rowView == null) {
            rowView = inflaterMaterialNoDescargado.inflate(R.layout.list_single_material_nodescargado, null);
            holder = new ViewHolder();

            holder.txtvNombreMaterialNoDescargado = (TextView) rowView.findViewById(R.id.txtvMaterialNodescargado);
            holder.txtvDescripcionMaterialNoDescargado = (TextView) rowView.findViewById(R.id.txtvDescripcionMaterialNoDescargado);
            holder.imgvMaterial = (ImageView) rowView.findViewById(R.id.imgvMaterialNoDescargado);
            holder.btnDescargarMaterial = (Button) rowView.findViewById(R.id.btnDescargarMaterial);

            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        holder.txtvNombreMaterialNoDescargado.setText(lstMaterialesNoDescargadosBE.get(position).getNombreMaterial());
        holder.txtvDescripcionMaterialNoDescargado.setText(lstMaterialesNoDescargadosBE.get(position).getDescripcion());
        holder.btnDescargarMaterial.setText("Descargar");
        //holder.imgvMaterial.setImageDrawable();

        return rowView;
    }

    public class ViewHolder {
        public TextView txtvNombreMaterialNoDescargado;
        public ImageView imgvMaterial;
        public TextView txtvDescripcionMaterialNoDescargado;
        public Button btnDescargarMaterial;
    }
}
