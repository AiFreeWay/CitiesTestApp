package aifree.com.citiestestapp.presentation.adapters.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import aifree.com.citiestestapp.R;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.FmtCountryViewController;


public class CityHolder extends BaseHolder<City, FmtCountryViewController> {

    public CityHolder(@NonNull Context context, FmtCountryViewController viewController) {
        super(context, viewController);
    }

    public CityHolder(@NonNull View view, FmtCountryViewController viewController) {
        super(view, viewController);
    }

    @Override
    public BaseHolder<City, FmtCountryViewController> create(ViewGroup viewGroup) {
        View view = viewInflater(viewGroup, R.layout.v_city_holder);
        return new CityHolder(view, mViewController);
    }

    @Override
    public void bind(City dataModel) {
        TextView title = (TextView) mView.findViewById(R.id.v_city_holder_title);
        mViewController.checkOnSelectedCity(this, dataModel);
        mView.setOnClickListener(v -> mViewController.setSelectedSity(dataModel));
        title.setText(dataModel.getTitle());
    }

    public void setUnselected() {
        mView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.default_background));
    }

    public void setSelected() {
        mView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.gray));
    }
}
