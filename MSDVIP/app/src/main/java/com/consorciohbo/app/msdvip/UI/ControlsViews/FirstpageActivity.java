package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.consorciohbo.app.msdvip.R;

public class FirstpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        //---------------------------------------------------------------------------------------------
        //Defino mi boton de registro
        Button btnSignUP = (Button) findViewById(R.id.btnSignUpFirst);

        //Asigno el evento onclick al boton
        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vistaRegistrar = new Intent(FirstpageActivity.this, SingupActivity.class);
                startActivity(vistaRegistrar);
            }
        });

        //---------------------------------------------------------------------------------------------
        //Defino mi boton de ingreso
        Button btnLogin = (Button) findViewById(R.id.btnLoginFirst);

        //Asigno el evento onClick al boton
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vistaLogin = new Intent(FirstpageActivity.this, LoginActivity.class);
                startActivity(vistaLogin);
            }
        });

    }
    //-------------------------------------------------------------------------------------------------

}
