package aifree.com.citiestestapp.applicication.di.modules;

import aifree.com.citiestestapp.presentation.screens.commons.base_components.BaseActivity;
import dagger.Module;


@Module
public class ActivityBaseModule {

    private BaseActivity mBaseActivity;

    public ActivityBaseModule(BaseActivity activity) {
        mBaseActivity = activity;
    }
}
