package aifree.com.citiestestapp.applicication.di.components;

import aifree.com.citiestestapp.applicication.di.modules.CitiesModule;
import aifree.com.citiestestapp.applicication.di.scopes.PerCities;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.AcMainViewController;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.FmtCountryViewController;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.FmtLikedViewController;
import dagger.Component;


@PerCities
@Component(modules = CitiesModule.class, dependencies = ActivityBaseComponent.class)
public interface CitiesComponent {

    void inject(AcMainViewController controller);
    void inject(FmtCountryViewController controller);
    void inject(FmtLikedViewController controller);
}
