package com.consorciohbo.app.msdvip;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TabHost;


public class EventosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        Resources res = getResources();

        TabHost tabs = (TabHost) findViewById(R.id.tabhostEventos);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Día");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Mes");
        tabs.addTab(spec);


        tabs.setCurrentTab(0);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
            }
        });

    }

}
