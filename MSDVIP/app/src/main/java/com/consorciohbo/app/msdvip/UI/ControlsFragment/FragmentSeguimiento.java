package com.consorciohbo.app.msdvip.UI.ControlsFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.consorciohbo.app.msdvip.R;

/**
 * Created by Diego on 16/12/15.
 */
public class FragmentSeguimiento extends ContentFragment {

    private String title;
    private int page;

    public static FragmentSeguimiento newInstance(String title) {
        FragmentSeguimiento fragmentSeguimiento = new FragmentSeguimiento();
        Bundle bdl = new Bundle(1);
        bdl.putString("", title);
        fragmentSeguimiento.setArguments(bdl);
        return fragmentSeguimiento;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_seguimiento,container,false);
        //colocar todo lo de la vista

        return view;
    }
}
