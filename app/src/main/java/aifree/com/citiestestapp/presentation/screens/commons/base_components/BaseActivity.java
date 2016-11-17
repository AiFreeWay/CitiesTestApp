package aifree.com.citiestestapp.presentation.screens.commons.base_components;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import aifree.com.citiestestapp.applicication.CitiesTestApplication;
import aifree.com.citiestestapp.applicication.di.components.ActivityBaseComponent;
import aifree.com.citiestestapp.applicication.di.components.DaggerActivityBaseComponent;
import aifree.com.citiestestapp.applicication.di.modules.ActivityBaseModule;


public abstract class BaseActivity<VC extends ViewController> extends AppCompatActivity {

    protected VC mViewControler;
    protected ActivityBaseComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityBaseComponent.builder()
                .applicationComponent(getAppInstanse().getAppComponent())
                .activityBaseModule(new ActivityBaseModule(this))
                .build();
    }

    @Nullable
    public ActivityBaseComponent getActivityComponent() {
        return mActivityComponent;
    }

    public CitiesTestApplication getAppInstanse() {
        return (CitiesTestApplication) getApplication();
    }

    @Nullable
    public VC getViewControler() {
        return mViewControler;
    }
}
