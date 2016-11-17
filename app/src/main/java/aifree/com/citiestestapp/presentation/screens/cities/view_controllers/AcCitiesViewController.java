package aifree.com.citiestestapp.presentation.screens.cities.view_controllers;

import javax.inject.Inject;

import aifree.com.citiestestapp.presentation.factories.MenuFragmentsFactory;
import aifree.com.citiestestapp.presentation.screens.cities.activities.CitiesActivity;
import aifree.com.citiestestapp.presentation.screens.commons.base_components.ViewController;


public class AcCitiesViewController extends ViewController<CitiesActivity> {

    @Inject
    MenuFragmentsFactory mMenuFragmentsFactory;

    public AcCitiesViewController(CitiesActivity view) {
        super(view);
        mView.getCitiesComponent()
                .inject(this);
    }

    public void start() {
        mView.getAdapter().loadData(mMenuFragmentsFactory.getTabs(), mMenuFragmentsFactory.getFragments());
    }
}
