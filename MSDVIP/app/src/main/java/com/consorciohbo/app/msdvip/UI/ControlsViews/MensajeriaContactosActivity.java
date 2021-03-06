package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import android.widget.ListView;

import com.consorciohbo.app.msdvip.BL.BE.ContactosBE;
import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.UI.Controls.ContactoArrayAdapter;

public class MensajeriaContactosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos_mensajeria);

        ArrayList<ContactosBE> contactosBEs = new ArrayList<ContactosBE>();
        ContactosBE objContacto = null;
        for (int i = 0; i < 3; i++){
            objContacto = new ContactosBE();

            objContacto.setCorreo("correo"+i+"@das.com");
            objContacto.setId("sfasf23f13w3");
            objContacto.setNombre("ContactoPrueba" + i);

            contactosBEs.add(objContacto);
        }
        //inicializa la lista de contactos

        ListView listView = (ListView) findViewById(R.id.listContactos);

        ContactoArrayAdapter contactoArrayAdapter = new ContactoArrayAdapter(this, getLayoutInflater(), contactosBEs);

        listView.setAdapter(contactoArrayAdapter);

    }

}
