package com.consorciohbo.app.msdvip.UI.ControlsFragment;

import android.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.consorciohbo.app.msdvip.R;

/**
 * Created by Diego on 16/12/15.
 */
public class PageViewActivity extends FragmentActivity{
    MyPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_content_seguimiento);

        List<Fragment> fragments = getFragments();

        pageAdapter = new MyPageAdapter(getSupportFragmentManager(),fragments);

        ViewPager pager = (ViewPager) findViewById(R.id.vpPager);
        pager.setAdapter(pageAdapter);
    }

    private List<Fragment> getFragments(){
        List<Fragment> flist = new ArrayList<Fragment>();

        flist.add(FragmentSeguimiento.newInstance("Día"));
        flist.add(FragmentSeguimiento.newInstance("Mes"));
        flist.add(FragmentSeguimiento.newInstance("Año"));
        return flist;
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}
