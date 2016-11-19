package aifree.com.citiestestapp.domain.mappers;


import java.util.ArrayList;
import java.util.List;

import aifree.com.citiestestapp.data.models.CountryData;
import aifree.com.citiestestapp.data.models.CountryRequest;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.models.Country;

public class CoutryMapper {

    public static List<Country> mapCountries(CountryRequest countryRequest) {
        List<Country> countries = new ArrayList<>();
        for (CountryData countryData : countryRequest.getResult()) {
            Country country = new Country(countryData.getId(), countryData.getName(), mapCities(countryData), countryData.getImageLink());
            countries.add(country);
        }
        return countries;
    }

    public static List<City> mapCities(CountryData countryData) {
        List<City> cities = new ArrayList<>();
        for (City city : countryData.getCities())
            cities.add(city);
        return cities;
    }

    public static List<City> mapCountriesToCities(List<Country> countries) {
        List<City> cities = new ArrayList<>();
        for (Country country : countries)
            cities.addAll(country.getItems());
        return cities;
    }
}

