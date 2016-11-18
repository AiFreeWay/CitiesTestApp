package aifree.com.citiestestapp.presentation.screens.main.view_controllers;

import java.util.List;

import javax.inject.Inject;

import aifree.com.citiestestapp.domain.interactors.CityInteractor;
import aifree.com.citiestestapp.presentation.adapters.MultiExpannadleRvAdapter;
import aifree.com.citiestestapp.presentation.adapters.holders.CityHolder;
import aifree.com.citiestestapp.presentation.adapters.holders.CountryHolder;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.models.Country;
import aifree.com.citiestestapp.presentation.screens.main.activities.MainActivity;
import aifree.com.citiestestapp.presentation.screens.main.fragments.CountriesFragment;
import aifree.com.citiestestapp.presentation.screens.commons.base_components.ViewController;
import aifree.com.citiestestapp.presentation.utils.Logger;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class FmtCountryViewController extends ViewController<CountriesFragment> {

    @Inject
    CityInteractor mCityInteractor;

    public FmtCountryViewController(CountriesFragment view) {
        super(view);
        ((MainActivity) mView.getActivity()).getCytiesComponent()
                .inject(this);
    }

    @Override
    public void start() {
        super.start();
        mCityInteractor.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(mView::showStartLoad)
                .subscribe(data -> {
                    mView.showSuccesLoad();
                    mView.loadData(createAdapter(data));} ,
                        e -> {
                            mView.showDeniedLoad();
                            Logger.logError(e);});
    }

    public void setSelectedSity(City city) {
        mCityInteractor.selectSity(city)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(id -> id > -1)
                .subscribe(lastSelectedCity ->
                    mView.getAdatper().notifyDataSetChanged(),
                        Logger::logError);
    }

    public void checkOnSelectedCity(CityHolder cityHolder, City model) {
        mCityInteractor.getSelectedCity()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(id -> id > -1)
                .subscribe(selectedCityId -> {
                            cityHolder.setUnselected();
                            if (selectedCityId == model.getId())
                                cityHolder.setSelected();},
                        Logger::logError);
    }

    private MultiExpannadleRvAdapter createAdapter(List<Country> data) {
        CountryHolder countryHolder = new CountryHolder(mView.getContext(), this);
        CityHolder cityHolder = new CityHolder(mView.getContext(), this);
        return new MultiExpannadleRvAdapter<>(countryHolder, cityHolder, data);
    }
}
