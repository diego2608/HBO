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
import com.consorciohbo.app.msdvip.UI.Controls.RecyclerItemClickListener;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MainActivity;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MaterialesMedicosActivity;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MensajeriaContactosActivity;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MensajeriaMarketingActivity;
import com.consorciohbo.app.msdvip.UI.ControlsViews.SitiosWebActivity;
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

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position) {
                            case 0:

                                break;
                            case 1:
                                Intent sitiosWebView = new Intent(getActivity(), SitiosWebActivity.class);
                                startActivity(sitiosWebView);
                                break;
                            case 2:
                                break;
                            case 3:
                                Intent materialesView = new Intent(getActivity(), MaterialesMedicosActivity.class);
                                startActivity(materialesView);
                                break;
                            case 4:
                                break;
                        }
                    }
                })
        );
        return viewFragment;



    }
}
