package com.consorciohbo.app.msdvip.UI.ControlsFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.consorciohbo.app.msdvip.BL.BE.CardBE;
import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MainActivity;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MensajeriaContactosActivity;
import com.consorciohbo.app.msdvip.UI.RecycleViewControllers.TravelListAdapter;
import com.consorciohbo.app.msdvip.UI.RecycleViewControllers.TravelListAdapterServicios;

/**
 * Created by Diego on 25/01/16.
 */
public class ContentFragmentServicios extends Fragment{
    private RecyclerView mRecyclerView;
    private TravelListAdapterServicios mAdapter;

    private StaggeredGridLayoutManager mStaggeredLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewFragment = inflater.inflate(R.layout.fragment_content_servicios,container,false);

        mRecyclerView = (RecyclerView) viewFragment.findViewById(R.id.listServicios);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mAdapter = new TravelListAdapterServicios(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return viewFragment;


      /*  mRecyclerView.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent vistaLogin = new Intent(ContentFragment.this,MensajeriaContactosActivity.class);
                startActivity(vistaLogin);
            }
        });*/

    }
}
