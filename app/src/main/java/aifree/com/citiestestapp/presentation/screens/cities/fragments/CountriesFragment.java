package aifree.com.citiestestapp.presentation.screens.cities.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import aifree.com.citiestestapp.R;
import aifree.com.citiestestapp.presentation.adapters.MultiExpannadleRvAdapter;
import aifree.com.citiestestapp.presentation.adapters.holders.CityHolder;
import aifree.com.citiestestapp.presentation.adapters.holders.CountryHolder;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.models.Country;
import aifree.com.citiestestapp.presentation.screens.cities.view_controllers.FmtCountryViewController;


public class CountriesFragment extends Fragment {

    private RecyclerView mRvCountries;
    private FmtCountryViewController mViewController;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_countries, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindView();
        mViewController = new FmtCountryViewController(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        MultiExpannadleRvAdapter<Country, City, FmtCountryViewController> adapter = createAdapter();
        mRvCountries.setLayoutManager(layoutManager);
        mRvCountries.setAdapter(adapter);
    }

    private void bindView() {
        mRvCountries = (RecyclerView) getActivity().findViewById(R.id.ac_cities__vp_body);
    }

    private MultiExpannadleRvAdapter createAdapter() {

        CountryHolder countryHolder = new CountryHolder(getContext(), mViewController);
        CityHolder cityHolder = new CityHolder(getContext(), mViewController);
        return new MultiExpannadleRvAdapter<>(countryHolder, cityHolder, getMockData());
    }

    private List<Country> getMockData() {
        List<Country> countries = new ArrayList<>();

        List<City> cities1 = new ArrayList<>();
        cities1.add(new City("A"));
        cities1.add(new City("B"));
        cities1.add(new City("C"));
        countries.add(new Country("CountryA", cities1));

        List<City> cities2 = new ArrayList<>();
        cities1.add(new City("D"));
        cities1.add(new City("E"));
        countries.add(new Country("CountryB", cities2));

        return countries;
    }
}
