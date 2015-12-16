package com.consorciohbo.app.msdvip.UI.Controls;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.consorciohbo.app.msdvip.BL.BE.PacientesBE;
import com.consorciohbo.app.msdvip.R;

import java.util.ArrayList;

/**
 * Created by Diego on 16/12/15.
 */
public class PacienteArrayAdapter extends ArrayAdapter<PacientesBE> {
    private LayoutInflater inflaterPacientes;
    private Context contextPaciente;
    private ArrayList<PacientesBE> lstPacientesBE;

    public PacienteArrayAdapter(Activity contextPaciente, LayoutInflater inflaterPacientes, ArrayList<PacientesBE> lstPacientesBE) {
        super(contextPaciente, R.layout.list_single_paciente);
        this.contextPaciente = contextPaciente;
        this.lstPacientesBE = lstPacientesBE;
    }

    @Override
    public int getCount() {
        if (lstPacientesBE == null)
            return 0;

        return lstPacientesBE.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        View rowView = convertView;

        if (rowView == null) {
            rowView = inflaterPacientes.inflate(R.layout.list_single_paciente,null);
            holder = new ViewHolder();

            holder.lblFecha = (TextView) rowView.findViewById(R.id.lblRowFecha);
            holder.lblNumPaciente = (TextView) rowView.findViewById(R.id.lblRowNumPaciente);
            holder.imgEstado = (ImageView) rowView.findViewById(R.id.imgRowPacienteEstado);

            rowView.setTag(holder);
        }else {
            holder = (ViewHolder) rowView.getTag();
        }
        holder.lblNumPaciente.setText(lstPacientesBE.get(position).getNum());
        holder.lblFecha.setText(lstPacientesBE.get(position).getFechaActividad());

        switch (lstPacientesBE.get(position).getEstado()){
            case "ACTIVO":
                holder.imgEstado.setBackgroundResource(R.drawable.imgafiliado);
                break;
            case "INACTIVO":
                holder.imgEstado.setBackgroundResource(R.drawable.imgnoafiliado);
                break;
        }

        return rowView;
    }

    public class ViewHolder {
        public ImageView imgEstado;
        public TextView lblFecha;
        public TextView lblNumPaciente;
    }

}
