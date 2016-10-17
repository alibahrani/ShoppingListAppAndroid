package com.bahrani.gazebogrills;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by aliba on 10/12/2016.
 */

public class ViewPagerFragment extends Fragment {

    public static final String KEY_PRODUCT_INDEX = "product_index";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int index = getArguments().getInt(KEY_PRODUCT_INDEX);
        getActivity().setTitle(Products.names[index]);
        View view = inflater.inflate(R.layout.fragment_viewpager,container,false);

        final DetailFragment detailFragment = new DetailFragment();
        final GallaryFragment gallaryFragment = new GallaryFragment();


        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? detailFragment : gallaryFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Details" : "Gallery";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout= (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;

    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
