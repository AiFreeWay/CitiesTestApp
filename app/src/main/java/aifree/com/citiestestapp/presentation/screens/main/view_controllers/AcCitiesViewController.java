package aifree.com.citiestestapp.presentation.screens.main.view_controllers;

import javax.inject.Inject;

import aifree.com.citiestestapp.presentation.factories.MenuFragmentsFactory;
import aifree.com.citiestestapp.presentation.screens.main.activities.MainActivity;
import aifree.com.citiestestapp.presentation.screens.commons.base_components.ViewController;


public class AcCitiesViewController extends ViewController<MainActivity> {

    @Inject
    MenuFragmentsFactory mMenuFragmentsFactory;

    public AcCitiesViewController(MainActivity view) {
        super(view);
        mView.getCytiesComponent()
                .inject(this);
    }

    public void start() {
        mView.getAdapter().loadData(mMenuFragmentsFactory.getTabs(), mMenuFragmentsFactory.getFragments());
    }
}
