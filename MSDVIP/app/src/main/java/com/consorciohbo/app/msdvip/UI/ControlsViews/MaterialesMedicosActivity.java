package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.consorciohbo.app.msdvip.BL.BE.MaterialesBE;
import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.UI.Controls.MaterialesNoDescargadosArrayAdapter;

import java.util.ArrayList;

public class MaterialesMedicosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiales_medicos);

        ArrayList<MaterialesBE> materialesBEs = new ArrayList<MaterialesBE>();
        MaterialesBE objMaterial = null;
        for (int i = 0; i < 3; i++){
            objMaterial = new MaterialesBE();

            objMaterial.setNombreMaterial("materialPrueba" + i);
            objMaterial.setId("sfasf23f13w3" + i);
            objMaterial.setDescripcion("dsadasdsadsadsadsadsad" + i);
            objMaterial.setEstado("HABILITADO");
            objMaterial.setUrlDescargar("WWW.Google.com");
            materialesBEs.add(objMaterial);
        }
        //inicializa la lista de contactos

        ListView listView = (ListView) findViewById(R.id.lstvMaterialesNoDescargados);

        MaterialesNoDescargadosArrayAdapter MaterialArrayAdapter = new MaterialesNoDescargadosArrayAdapter(this, getLayoutInflater(), materialesBEs);

        listView.setAdapter(MaterialArrayAdapter);
    }
}
