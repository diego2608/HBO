package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.consorciohbo.app.msdvip.BL.BE.WebsitesBE;
import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.UI.Controls.WebsitesArrayAdapter;

import java.util.ArrayList;

public class SitiosWebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios_web);

        ArrayList<WebsitesBE> lstWebsitesBE = new ArrayList<WebsitesBE>();
        WebsitesBE objWebsite = null;

        for (int i = 0; i < 3; i++){
            objWebsite = new WebsitesBE();

            objWebsite.setUrlWebsite("www.google.com/" + i );
            objWebsite.setId("sfasf23f13w3");

            lstWebsitesBE.add(objWebsite);
        }
        ListView lstView = (ListView) findViewById(R.id.lstvWebsites);

        WebsitesArrayAdapter websitesArrayAdapter = new WebsitesArrayAdapter(this,getLayoutInflater(),lstWebsitesBE);
        lstView.setAdapter(websitesArrayAdapter);
    }
}
