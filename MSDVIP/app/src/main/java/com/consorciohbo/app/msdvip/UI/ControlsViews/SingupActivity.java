package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.consorciohbo.app.msdvip.R;

public class SingupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        //-------------------------------------------------------------------------------------------
        //Defino mi boton Guardar Formulario
        Button btnSaveFormulario = (Button) findViewById(R.id.btnValidarSignUp);

        //Asigno el evenyo onclick al botn
        btnSaveFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vistaFormulario = new Intent(SingupActivity.this, PerfilpageActivity.class);
                startActivity(vistaFormulario);
            }
        });
    }
}
