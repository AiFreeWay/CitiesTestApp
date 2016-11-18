package aifree.com.citiestestapp.presentation.adapters.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;


import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.screens.cities.view_controllers.FmtCountryViewController;


public class CityHolder extends BaseChildHolder<City, FmtCountryViewController> {

    public CityHolder(@NonNull Context context, FmtCountryViewController viewController) {
        super(context, viewController);
    }

    @Override
    public BaseChildHolder<City, FmtCountryViewController> create(ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void bind(City dataModel) {

    }
}
