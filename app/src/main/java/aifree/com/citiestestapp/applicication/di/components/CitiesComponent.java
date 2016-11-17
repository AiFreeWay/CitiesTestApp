package aifree.com.citiestestapp.applicication.di.components;

import aifree.com.citiestestapp.applicication.di.modules.CitiesModule;
import aifree.com.citiestestapp.applicication.di.scopes.PerCities;
import aifree.com.citiestestapp.presentation.screens.cities.view_controllers.AcCitiesViewController;
import dagger.Component;


@PerCities
@Component(modules = CitiesModule.class, dependencies = ActivityBaseComponent.class)
public interface CitiesComponent {

    void inject(AcCitiesViewController controller);

}
