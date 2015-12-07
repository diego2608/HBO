package com.consorciohbo.app.msdvip;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TabHost;
import android.widget.Toast;

import com.consorciohbo.app.library.MaterialDialog;

public class EventosActivity extends AppCompatActivity {

    MaterialDialog mMaterialDialog;

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

        spec = tabs.newTabSpec("mitab2");
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


    //-----------Popup

    public void buttonPress(View view) {
        // show imm
        InputMethodManager imm = (InputMethodManager) this.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void init(View v) {
        mMaterialDialog = new MaterialDialog(this);
    }

    public void show(View v) {


        if (mMaterialDialog != null) {
            mMaterialDialog.setTitle("MaterialDialog").setMessage(
                    "Hi! This is a MaterialDialog. It's very easy to use, you just new and show() it " +
                            "then the beautiful AlertDialog will show automatically. It is artistic, conforms to Google Material Design." +
                            " I hope that you will like it, and enjoy it. ^ ^")
                    //mMaterialDialog.setBackgroundResource(R.drawable.background);
                    .setPositiveButton("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mMaterialDialog.dismiss();
                            Toast.makeText(EventosActivity.this, "Agregado",
                                    Toast.LENGTH_LONG).show();
                        }
                    }).setNegativeButton("CANCEL", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMaterialDialog.dismiss();
                    Toast.makeText(EventosActivity.this, "Cancel", Toast.LENGTH_LONG)
                            .show();
                }
            }).setCanceledOnTouchOutside(false)
                    // You can change the message anytime.
                    .setOnDismissListener(
                            new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {

                                }
                            }).show();
        } /*else {
            Toast.makeText(getApplicationContext(), "You should init firstly!",
                    Toast.LENGTH_SHORT).show();
        }*/
    }


}
