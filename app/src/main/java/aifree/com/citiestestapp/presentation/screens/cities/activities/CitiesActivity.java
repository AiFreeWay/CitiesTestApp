package aifree.com.citiestestapp.presentation.screens.cities.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import aifree.com.citiestestapp.R;
import aifree.com.citiestestapp.applicication.di.components.CitiesComponent;
import aifree.com.citiestestapp.applicication.di.components.DaggerCitiesComponent;
import aifree.com.citiestestapp.applicication.di.modules.CitiesModule;
import aifree.com.citiestestapp.presentation.adapters.ViewPagerTabsAdapter;
import aifree.com.citiestestapp.presentation.screens.cities.view_controllers.AcCitiesViewController;
import aifree.com.citiestestapp.presentation.screens.commons.base_components.BaseActivity;

public class CitiesActivity extends BaseActivity<AcCitiesViewController> {

    private Toolbar mToolbar;
    private TabLayout mTlTabs;
    private ViewPager mVpBody;

    private ViewPagerTabsAdapter mAdapter;
    private CitiesComponent mCitiesComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_cities);
        bindViews();
        initActionBar();
        mAdapter = new ViewPagerTabsAdapter(getSupportFragmentManager(), mTlTabs, mVpBody);
        mCitiesComponent = DaggerCitiesComponent.builder()
                .activityBaseComponent(getActivityComponent())
                .citiesModule(new CitiesModule(this))
                .build();
        mViewControler = new AcCitiesViewController(this);
        mViewControler.start();
    }

    public CitiesComponent getCitiesComponent() {
        return mCitiesComponent;
    }

    public ViewPagerTabsAdapter getAdapter() {
        return mAdapter;
    }

    public TabLayout getTlTabs() {
        return mTlTabs;
    }

    private void bindViews() {
        mToolbar = (Toolbar) findViewById(R.id.ac_cities_toolbar);
        mTlTabs = (TabLayout) findViewById(R.id.ac_cities_tl_tabs);
        mVpBody = (ViewPager) findViewById(R.id.ac_cities__vp_body);
    }

    private void initActionBar() {
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }
}
