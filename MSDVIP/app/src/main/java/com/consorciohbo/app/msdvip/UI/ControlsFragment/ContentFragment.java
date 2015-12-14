package com.consorciohbo.app.msdvip.UI.ControlsFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.UI.RecycleViewControllers.TravelListAdapter;


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

        return viewFragment;
    }


}
