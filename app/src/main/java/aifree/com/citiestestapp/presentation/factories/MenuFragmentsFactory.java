package aifree.com.citiestestapp.presentation.factories;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import aifree.com.citiestestapp.presentation.screens.commons.base_components.BaseFragment;
import aifree.com.citiestestapp.presentation.screens.main.activities.MainActivity;
import aifree.com.citiestestapp.presentation.screens.main.fragments.CountriesFragment;
import aifree.com.citiestestapp.presentation.screens.main.fragments.LikedFragment;
import aifree.com.citiestestapp.presentation.screens.main.fragments.OptionsFragment;

public class MenuFragmentsFactory {

    private SortedMap<Integer, TabLayout.Tab> mTabs;
    private SortedMap<Integer, BaseFragment> mFragments;

    public MenuFragmentsFactory(MainActivity mainActivity) {
        generateTabs(mainActivity.getTlTabs());
        generateFragments();
    }

    public TabLayout.Tab getTabtById(int id) {
        return mTabs.get(id);
    }

    public BaseFragment getFragmentById(int id) {
        return mFragments.get(id);
    }

    public List<TabLayout.Tab> getTabs() {
        return new ArrayList<>(mTabs.values());
    }

    public List<BaseFragment> getFragments() {
        return new ArrayList<>(mFragments.values());
    }

    private void generateTabs(TabLayout tabLayout) {
        mTabs = new TreeMap<>();
        mTabs.put(Fragments.COUNTRIES.id, tabLayout.newTab().setText("Страны"));
        mTabs.put(Fragments.LIKED.id, tabLayout.newTab().setText("Избранное"));
        mTabs.put(Fragments.OPTIONS.id, tabLayout.newTab().setText("Настройки"));
    }

    private void generateFragments() {
        mFragments = new TreeMap<>();
        mFragments.put(Fragments.COUNTRIES.id, new CountriesFragment());
        mFragments.put(Fragments.LIKED.id, new LikedFragment());
        mFragments.put(Fragments.OPTIONS.id, new OptionsFragment());
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
