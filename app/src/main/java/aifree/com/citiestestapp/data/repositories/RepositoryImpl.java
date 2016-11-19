package aifree.com.citiestestapp.data.repositories;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import aifree.com.citiestestapp.data.db_store.DBController;
import aifree.com.citiestestapp.data.models.CountryRequest;
import aifree.com.citiestestapp.data.net_store.NetworkController;
import aifree.com.citiestestapp.domain.mappers.CoutryMapper;
import aifree.com.citiestestapp.domain.repositories.Repository;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.models.Country;
import rx.Observable;

@Singleton
public class RepositoryImpl implements Repository {

    private DBController mDBController;
    private NetworkController mNetworkController;

    @Inject
    public RepositoryImpl(Context context) {
        mDBController = new DBController(context);
        mNetworkController = new NetworkController();
    }

    @Override
    public Observable<Integer> addCityToLiked(City city) {
        return Observable.just(mDBController.addCityToLiked(city));
    }

    @Override
    public Observable<Integer> removeCityFromLiked(City city) {
        return Observable.just(mDBController.removeCityFromLiked(city));
    }

    @Override
    public Observable<Integer> selectSity(City city) {
        return Observable.just(mDBController.selectSity(city));
    }

    @Override
    public Observable<Integer> getSelectedCity() {
        return Observable.just(mDBController.getSelectedCity());
    }

    @Override
    public Observable<List<Integer>> getLikedCities() {
        return Observable.just(mDBController.getLikedCities());
    }

    @Override
    public Observable<CountryRequest> getCountries() {
        return mNetworkController.getCities();
    }
}
