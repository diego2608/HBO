package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.consorciohbo.app.showcaseviewlibrary.MaterialShowcaseView;

import com.consorciohbo.app.msdvip.R;

public class PerfilpageActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaro botones
    private Button btnGuardarFrm;
    private Button btnEditFrm;


    //Declaro EditText
    private EditText etxtNombreFrm;
    private EditText etxtApellidoFrm;
    private EditText etxtEspecialidadFrm;
    private EditText etxtPasswordFrm;
    private EditText etxtCelularFrm;
    private EditText etxtCorreoFrm;





    private static final String SHOWCASE_ID = "simple example";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfilpage);

        btnEditFrm = (Button) findViewById(R.id.btnEditarPerfilEditar);
        btnEditFrm.setOnClickListener(this);

        btnGuardarFrm = (Button) findViewById(R.id.btnSaveForm);
        btnGuardarFrm.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnSaveForm){

            presentShowcaseView(0);
            disableEditText();

        }else if(v.getId() == R.id.btnEditarPerfilEditar){
            enableEditText();
            btnGuardarFrm.setVisibility(v.VISIBLE);
        }

    }

    private void enableEditText(){
        etxtNombreFrm.setEnabled(true);
        etxtApellidoFrm.setEnabled(true);
        etxtEspecialidadFrm.setEnabled(true);
        etxtPasswordFrm.setEnabled(true);
        etxtCelularFrm.setEnabled(true);
        etxtCorreoFrm.setEnabled(true);
    }

    private void disableEditText(){
        etxtNombreFrm.setEnabled(false);
        etxtApellidoFrm.setEnabled(false);
        etxtEspecialidadFrm.setEnabled(false);
        etxtPasswordFrm.setEnabled(false);
        etxtCelularFrm.setEnabled(false);
        etxtCorreoFrm.setEnabled(false);
    }

    private void presentShowcaseView(int withDelay) {
        new MaterialShowcaseView.Builder(this)
                .setTarget(btnGuardarFrm)
                .setDismissText("Aceptar")
                .setContentText("Sus datos han sido actualizados satisfactoriamente")
                .setDelay(withDelay) // optional but starting animations immediately in onCreate can make them choppy
                .singleUse(SHOWCASE_ID) // provide a unique ID used to ensure it is only shown once
                .show();

        resetShowcaseView(10000000);

        //volver a inhabilitar el boton guardar


    }

    private void resetShowcaseView(int withDelay){
        MaterialShowcaseView.resetSingleUse(this, SHOWCASE_ID);
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
    }


}
