package com.consorciohbo.app.msdvip.UI.ControlsFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import com.consorciohbo.app.msdvip.R;


public class ContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewFragment = inflater.inflate(R.layout.fragment_content_comunicacion,container,false);

        return viewFragment;
    }


}
