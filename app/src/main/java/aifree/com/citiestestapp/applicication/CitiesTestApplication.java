package aifree.com.citiestestapp.applicication;


import android.app.Application;

import aifree.com.citiestestapp.applicication.di.components.ApplicationComponent;
import aifree.com.citiestestapp.applicication.di.components.DaggerApplicationComponent;
import aifree.com.citiestestapp.applicication.di.modules.ApplicationModule;


public class CitiesTestApplication extends Application {

    private ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }
}
