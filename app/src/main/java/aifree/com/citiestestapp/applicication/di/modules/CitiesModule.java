package aifree.com.citiestestapp.applicication.di.modules;

import aifree.com.citiestestapp.presentation.factories.MenuFragmentsFactory;
import aifree.com.citiestestapp.presentation.screens.cities.activities.CitiesActivity;
import dagger.Module;
import dagger.Provides;


@Module
public class CitiesModule {

    private MenuFragmentsFactory mMenuFragmentsFactory;

    public CitiesModule(CitiesActivity citiesActivity) {
        mMenuFragmentsFactory = new MenuFragmentsFactory(citiesActivity);
    }

    @Provides
    public MenuFragmentsFactory provideMenuFragmentsFactory() {
        return mMenuFragmentsFactory;
    }
}
