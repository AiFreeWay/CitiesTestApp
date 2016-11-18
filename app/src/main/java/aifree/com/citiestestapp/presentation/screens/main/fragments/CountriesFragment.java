package aifree.com.citiestestapp.presentation.screens.main.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rey.material.widget.ProgressView;

import aifree.com.citiestestapp.R;
import aifree.com.citiestestapp.presentation.adapters.MultiExpannadleRvAdapter;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.FmtCountryViewController;


public class CountriesFragment extends Fragment {

    private RecyclerView mRvCountries;
    private ProgressView mPvProgress;
    private FmtCountryViewController mViewController;
    private MultiExpannadleRvAdapter mAdatper;

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
        mRvCountries.setLayoutManager(layoutManager);
        mViewController.start();
    }

    public void loadData(MultiExpannadleRvAdapter adapter) {
        mAdatper = adapter;
        mRvCountries.setAdapter(adapter);
    }

    public void showStartLoad() {
        mPvProgress.start();
    }

    public void showSuccesLoad() {
        mPvProgress.stop();
    }

    public void showDeniedLoad() {
        mPvProgress.stop();
        Toast.makeText(getContext(), R.string.cant_load_data, Toast.LENGTH_SHORT).show();
    }

    public MultiExpannadleRvAdapter getAdatper() {
        return mAdatper;
    }

    private void bindView() {
        mRvCountries = (RecyclerView) getActivity().findViewById(R.id.fmt_countries_rv_countries);
        mPvProgress = (ProgressView) getActivity().findViewById(R.id.fmt_countries_pv_progress);
    }
}
