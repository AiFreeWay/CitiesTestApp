package aifree.com.citiestestapp.domain.executors;


import java.util.List;

import javax.inject.Inject;

import aifree.com.citiestestapp.domain.mappers.CoutryMapper;
import aifree.com.citiestestapp.domain.repositories.Repository;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.models.Country;
import aifree.com.citiestestapp.domain.interactors.CityInteractor;
import rx.Observable;

public class CityInteractorImpl implements CityInteractor {

    private Repository mRepository;

    @Inject
    public CityInteractorImpl(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<Integer> selectSity(City city) {
        return mRepository.selectSity(city);
    }

    @Override
    public Observable<Integer> addCityToLiked(City city) {
        return mRepository.addCityToLiked(city);
    }

    @Override
    public Observable<Integer> removeCityFromLiked(City city) {
        return mRepository.removeCityFromLiked(city);
    }

    @Override
    public Observable<Integer> getSelectedCity() {
        return mRepository.getSelectedCity();
    }

    @Override
    public Observable<List<Country>> getCountries() {
        return mRepository.getCountries()
                .flatMap(countryRequest -> Observable.just(CoutryMapper.mapCountries(countryRequest)))
                .cache();
    }

    @Override
    public Observable<List<Integer>> getLikedCities() {
        return mRepository.getLikedCities();
    }

    @Override
    public Observable<List<City>> getCities() {
        return getCountries()
                .flatMap(countries -> Observable.just(CoutryMapper.mapCountriesToCities(countries)))
                .cache();
    }
}
