package aifree.com.citiestestapp.domain.repositories;


import java.util.List;

import aifree.com.citiestestapp.data.models.CountryRequest;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.models.Country;
import rx.Observable;

public interface Repository {

    Observable<Integer> addCityToLiked(City city);
    Observable<Integer> removeCityFromLiked(City city);
    Observable<Integer> selectSity(City city);
    Observable<Integer> getSelectedCity();
    Observable<List<Integer>> getLikedCities();
    Observable<CountryRequest> getCountries();
}
