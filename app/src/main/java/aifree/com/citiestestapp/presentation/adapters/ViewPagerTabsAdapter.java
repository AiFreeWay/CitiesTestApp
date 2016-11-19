package aifree.com.citiestestapp.presentation.adapters;


import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.Collections;
import java.util.List;

import aifree.com.citiestestapp.presentation.screens.commons.base_components.BaseFragment;

public class ViewPagerTabsAdapter extends FragmentPagerAdapter {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<TabLayout.Tab> mTabs = Collections.emptyList();
    private List<BaseFragment> mFragments = Collections.emptyList();
    private TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            mViewPager.setCurrentItem(tab.getPosition());
            mFragments.get(tab.getPosition()).refresh();
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    public ViewPagerTabsAdapter(FragmentManager fragmentManager, TabLayout tabLayout, ViewPager viewPager) {
        super(fragmentManager);
        mTabLayout = tabLayout;
        mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(tabSelectedListener);
    }

    @Override
    public BaseFragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    public void loadData(List<TabLayout.Tab> tabs, List<BaseFragment> fragments) {
        mTabs = tabs;
        mFragments = fragments;
        for (TabLayout.Tab tab : tabs)
            mTabLayout.addTab(tab);
        notifyDataSetChanged();
    }
}
