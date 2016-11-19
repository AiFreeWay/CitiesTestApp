package aifree.com.citiestestapp.presentation.screens.main.view_controllers;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import aifree.com.citiestestapp.domain.interactors.CityInteractor;
import aifree.com.citiestestapp.presentation.adapters.holders.LikedHolder;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.screens.commons.base_components.ViewController;
import aifree.com.citiestestapp.presentation.screens.main.activities.MainActivity;
import aifree.com.citiestestapp.presentation.screens.main.fragments.LikedFragment;
import aifree.com.citiestestapp.presentation.utils.Logger;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class FmtLikedViewController extends ViewController<LikedFragment> {

    @Inject
    CityInteractor mCityInteractor;

    private List<Integer> mLikedCities = Collections.emptyList();

    public FmtLikedViewController(LikedFragment view) {
        super(view);
        ((MainActivity) mView.getActivity()).getCytiesComponent()
                .inject(this);
    }

    @Override
    public void start() {
        super.start();
        mCityInteractor.getLikedCities()
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe(mView::showStartLoad)
                .flatMap(liked -> {
                    mLikedCities = liked;
                    return mCityInteractor.getCities();})
                .map(this::findLikedCities)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                            mView.showSuccesLoad();
                            mView.getAdatper().loadData(data);} ,
                        e -> {
                            mView.showDeniedLoad();
                            Logger.logError(e);});
    }

    public void showUnlickedCityDialog(City city) {
        mView.showRemoveFromLikedDialog(city);
    }

    public void unlikedCity(City city) {
        mCityInteractor.removeCityFromLiked(city)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::removeFromLiked,
                        Logger::logError);
    }

    private List<City> findLikedCities(List<City> allCities) {
        List<City> likedCities = new ArrayList<>();
        for (Integer likedCityId : mLikedCities) {
            for (City city : allCities)
                if (likedCityId == city.getId())
                    likedCities.add(city);
        }
        return likedCities;
    }

    private void removeFromLiked(int id) {
        List<City> cities = mView.getAdatper().getData();
        for (int i=0; i < cities.size(); i++)
            if (cities.get(i).getId() == id) {
                cities.remove(i);
                break;
            }
        mView.getAdatper().loadData(cities);
    }
}
