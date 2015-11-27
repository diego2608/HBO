package com.consorciohbo.app.msdvip;

import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.consorciohbo.app.msdvip.BL.BE.ContactosBE;
import com.consorciohbo.app.msdvip.UI.Controls.ContactoArrayAdapter;

public class ListMensajeriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mensajeria);

        ArrayList<ContactosBE> contactosBEs = null;
        //inicializa la lista de contactos

        ListView listView = (ListView) findViewById(R.id.listContactos);

        ContactoArrayAdapter contactoArrayAdapter = new ContactoArrayAdapter(this, getLayoutInflater(), contactosBEs);

        listView.setAdapter(contactoArrayAdapter);

    }

}
