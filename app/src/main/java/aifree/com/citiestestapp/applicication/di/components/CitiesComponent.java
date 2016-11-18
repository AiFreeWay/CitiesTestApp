package aifree.com.citiestestapp.applicication.di.components;

import aifree.com.citiestestapp.applicication.di.modules.CitiesModule;
import aifree.com.citiestestapp.applicication.di.scopes.PerCities;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.AcCitiesViewController;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.FmtCountryViewController;
import dagger.Component;


@PerCities
@Component(modules = CitiesModule.class, dependencies = ActivityBaseComponent.class)
public interface CitiesComponent {

    void inject(AcCitiesViewController controller);
    void inject(FmtCountryViewController controller);

}
