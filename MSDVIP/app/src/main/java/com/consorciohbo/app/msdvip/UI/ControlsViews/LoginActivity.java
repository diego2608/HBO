package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.WS.MedicoObtenerWS;

public class LoginActivity extends AppCompatActivity {
    private EditText txtLoginCMD;
    private EditText txtPasswordCMD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //-------------------------------------------------------------------------------------------
        //Defino mi boton Ingresar
        Button btnLogin = (Button) findViewById(R.id.btnIniciarSecionLogin);

        //Asigno el evenyo onclick al botn
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vistaLogin = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(vistaLogin);
            }
        });

    }


}
