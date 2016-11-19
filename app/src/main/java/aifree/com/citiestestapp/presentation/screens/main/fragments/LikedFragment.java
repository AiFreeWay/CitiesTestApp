package aifree.com.citiestestapp.presentation.screens.main.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rey.material.app.Dialog;
import com.rey.material.widget.ProgressView;

import aifree.com.citiestestapp.R;
import aifree.com.citiestestapp.presentation.adapters.MultiRvAdapter;
import aifree.com.citiestestapp.presentation.adapters.holders.LikedHolder;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.screens.commons.base_components.BaseFragment;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.FmtLikedViewController;

public class LikedFragment extends BaseFragment {

    private RecyclerView mRvCountries;
    private ProgressView mPvProgress;
    private FmtLikedViewController mViewController;
    private MultiRvAdapter<City, FmtLikedViewController> mAdatper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_liked, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindView();
        mViewController = new FmtLikedViewController(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdatper = new MultiRvAdapter<City, FmtLikedViewController>(new LikedHolder(getContext(), mViewController));
        mRvCountries.setLayoutManager(layoutManager);
        mRvCountries.setAdapter(mAdatper);
        mViewController.start();
    }

    @Override
    public void refresh() {
        try {
            mViewController.start();
        } catch (Exception e) {

        }
    }

    public void showRemoveFromLikedDialog(City city) {
        Dialog dialog = new Dialog(getContext());
        dialog.title("Удалить "+city.getTitle()+" из избранного?")
                .titleColor(ContextCompat.getColor(getContext(), R.color.moray))
                .positiveActionTextColor(ContextCompat.getColor(getContext(), R.color.marron))
                .positiveAction("Да")
                .positiveActionClickListener(v -> {
                    mViewController.unlikedCity(city);
                    dialog.dismiss();})
                .negativeActionTextColor(ContextCompat.getColor(getContext(), R.color.anthracite))
                .negativeAction("Нет")
                .negativeActionClickListener(v -> dialog.dismiss())
                .cancelable(true)
                .show();

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

    public MultiRvAdapter<City, FmtLikedViewController> getAdatper() {
        return mAdatper;
    }

    private void bindView() {
        mRvCountries = (RecyclerView) getActivity().findViewById(R.id.fmt_liked_rv_countries);
        mPvProgress = (ProgressView) getActivity().findViewById(R.id.fmt_liked_pv_progress);
    }
}
