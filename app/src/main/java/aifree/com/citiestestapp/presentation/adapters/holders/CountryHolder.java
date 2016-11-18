package aifree.com.citiestestapp.presentation.adapters.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import aifree.com.citiestestapp.presentation.models.Country;
import aifree.com.citiestestapp.presentation.screens.cities.view_controllers.FmtCountryViewController;


public class CountryHolder extends BaseGroupHolder<Country, FmtCountryViewController> {

    public CountryHolder(@NonNull Context context, FmtCountryViewController viewController) {
        super(context, viewController);
    }

    @Override
    public BaseGroupHolder<Country, FmtCountryViewController> create(ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void bind(Country dataModel) {

    }
}
