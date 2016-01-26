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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.consorciohbo.app.msdvip.BL.BE.CardBE;
import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.UI.Controls.RecyclerItemClickListener;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MainActivity;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MensajeriaContactosActivity;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MensajeriaMarketingActivity;
import com.consorciohbo.app.msdvip.UI.RecycleViewControllers.TravelListAdapter;

//este es el manejador del fragment
public class ContentFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private TravelListAdapter mAdapter;

    private StaggeredGridLayoutManager mStaggeredLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewFragment = inflater.inflate(R.layout.fragment_content_comunicacion,container,false);

        mRecyclerView = (RecyclerView) viewFragment.findViewById(R.id.listComunicacion);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mAdapter = new TravelListAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);




        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(),new RecyclerItemClickListener.OnItemClickListener(){
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position){
                            case 0:

                                Intent contactosView = new Intent(getActivity(),MensajeriaContactosActivity.class);
                                startActivity(contactosView);
                                break;
                            case 1:
                                Intent marketingView = new Intent(getActivity(), MensajeriaMarketingActivity.class);
                                startActivity(marketingView);
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                    }
                })
        );

        return viewFragment;
        //pendejo.... :'v
        //oe para llamar a un acvity des aca
        // usas get Activity y le mandas el Intent , has usado inetnt no?si
    }



}