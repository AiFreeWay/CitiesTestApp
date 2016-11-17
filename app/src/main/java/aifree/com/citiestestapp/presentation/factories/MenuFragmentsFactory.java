package aifree.com.citiestestapp.presentation.factories;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import aifree.com.citiestestapp.presentation.screens.cities.activities.CitiesActivity;

public class MenuFragmentsFactory {

    private SortedMap<Integer, TabLayout.Tab> mTabs;
    private SortedMap<Integer, Fragment> mFragments;

    public MenuFragmentsFactory(CitiesActivity citiesActivity) {
        generateTabs(citiesActivity.getTlTabs());
        generateFragments();
    }

    public TabLayout.Tab getTabtById(int id) {
        return mTabs.get(id);
    }

    public Fragment getFragmentById(int id) {
        return mFragments.get(id);
    }

    public List<TabLayout.Tab> getTabs() {
        return new ArrayList<>(mTabs.values());
    }

    public List<Fragment> getFragments() {
        return new ArrayList<>(mFragments.values());
    }

    public void generateTabs(TabLayout tabLayout) {
        mTabs = new TreeMap<>();
        mTabs.put(Fragments.COUNTRIES.id, tabLayout.newTab().setText("Страны"));
        mTabs.put(Fragments.LIKED.id, tabLayout.newTab().setText("Избранное"));
        mTabs.put(Fragments.OPTIONS.id, tabLayout.newTab().setText("Настройки"));
    }

    private void generateFragments() {
        mFragments = new TreeMap<>();
        mFragments.put(Fragments.COUNTRIES.id, new Fragment());
        mFragments.put(Fragments.LIKED.id, new Fragment());
        mFragments.put(Fragments.OPTIONS.id, new Fragment());
    }

    public enum Fragments {
        COUNTRIES(0),
        LIKED(1),
        OPTIONS(2);

        public int id;

        Fragments(int id) {
            this.id = id;
        }
    }
}
