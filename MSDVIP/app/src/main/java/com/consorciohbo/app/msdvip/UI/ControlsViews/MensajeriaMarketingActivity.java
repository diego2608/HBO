package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.consorciohbo.app.msdvip.BL.BE.AreasMarketingBE;
import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.UI.Controls.MarketingArrayAdapter;

import java.util.ArrayList;

public class MensajeriaMarketingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajeria_marketing);

        ArrayList<AreasMarketingBE> lstAreasBE = null;
        //inicializa la lista de contactos
        ListView lstView = (ListView) findViewById(R.id.lstvCorreoAreaMarketing);

        MarketingArrayAdapter marketingArrayAdapter = new MarketingArrayAdapter(this, getLayoutInflater(),lstAreasBE);
                lstView.setAdapter(marketingArrayAdapter);
    }
}
