package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.consorciohbo.app.showcaseviewlibrary.MaterialShowcaseView;

import com.consorciohbo.app.msdvip.R;

public class PerfilpageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnValidarFrm;

    private static final String SHOWCASE_ID = "simple example";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfilpage);
        btnValidarFrm = (Button) findViewById(R.id.btnValidarFormulario);
        btnValidarFrm.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnValidarFormulario){
            presentShowcaseView(0);
        }

    }

    private void presentShowcaseView(int withDelay) {
        new MaterialShowcaseView.Builder(this)
                .setTarget(btnValidarFrm)
                .setDismissText("Satisfactoriamente")
                .setContentText("Su cuenta ha sido creada")
                .setDelay(withDelay) // optional but starting animations immediately in onCreate can make them choppy
                .singleUse(SHOWCASE_ID) // provide a unique ID used to ensure it is only shown once
                .show();

        resetShowcaseView(10000000);
    }

    private void resetShowcaseView(int withDelay){
        MaterialShowcaseView.resetSingleUse(this, SHOWCASE_ID);
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
    }


}
