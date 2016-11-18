package aifree.com.citiestestapp.applicication.di.modules;

import aifree.com.citiestestapp.domain.executors.CityInteractorImpl;
import aifree.com.citiestestapp.domain.interactors.CityInteractor;
import aifree.com.citiestestapp.presentation.factories.MenuFragmentsFactory;
import aifree.com.citiestestapp.presentation.screens.main.activities.MainActivity;
import dagger.Module;
import dagger.Provides;


@Module
public class CitiesModule {

    private MenuFragmentsFactory mMenuFragmentsFactory;

    public CitiesModule(MainActivity mainActivity) {
        mMenuFragmentsFactory = new MenuFragmentsFactory(mainActivity);
    }

    @Provides
    public MenuFragmentsFactory provideMenuFragmentsFactory() {
        return mMenuFragmentsFactory;
    }

    @Provides
    public CityInteractor provideCityInteractor(CityInteractorImpl cityInteractor) {
        return cityInteractor;
    }
}
