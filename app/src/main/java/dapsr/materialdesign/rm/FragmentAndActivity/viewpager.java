package dapsr.materialdesign.rm.FragmentAndActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dapsr.materialdesign.rm.R;
import dapsr.materialdesign.rm.Tabs.SlidingTabLayout;

/**
 * Created by rajanmaurya on 24/3/15.
 */
public class viewpager extends Fragment  {

    ViewPager vp;
    public SlidingTabLayout mTabs;

    public static viewpager getInstance(int position) {
        viewpager myFragment = new viewpager();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.viewpager, container, false);


        mTabs = (SlidingTabLayout) layout.findViewById(R.id.materialTabHost);
        vp = (ViewPager) layout.findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        vp.setAdapter(adapter);
        mTabs.setViewPager(vp);
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorPrimaryLight);    //define any color in xml resources and set it here, I have used white
            }




        });

        return layout;

    }




    class ViewPagerAdapter extends FragmentStatePagerAdapter {


        public Context context;

        String [] title = {"TAB1","TAB2","TAB3","TAB4","TAB5","TAB6","TAB7","TAB8","TAB9","TAB10"};
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);


        }


        public Fragment getItem(int num) {
//            switch (num) {
//                case 0:
//
//                    return MyFragment.getInstance(num);
//
//                case 1:
//
//                    return MyFragment.getInstance(num);
//
//                case 2:

                    return MyFragment.getInstance(num);

//
//            }
//            return null;

        }


        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }


    }

}