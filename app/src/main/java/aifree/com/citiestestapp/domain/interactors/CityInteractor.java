package aifree.com.citiestestapp.domain.interactors;


import java.util.List;

import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.models.Country;
import rx.Observable;

public interface CityInteractor {

    Observable<Integer> selectSity(City city);
    Observable<Integer> addCityToLiked(City city);
    Observable<Integer> removeCityFromLiked(City city);
    Observable<Integer> getSelectedCity();
    Observable<List<Country>> getCountries();
    Observable<List<Integer>> getLikedCities();
}
