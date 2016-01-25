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
import com.consorciohbo.app.msdvip.R;

/**
 * Created by Diego on 25/01/16.
 */
public class ContentFragmentAfiliacion extends Fragment {
    private StaggeredGridLayoutManager mStaggeredLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewFragment = inflater.inflate(R.layout.fragment_nueva_afiliacion,container,false);


        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);


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
