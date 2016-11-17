package aifree.com.citiestestapp.applicication.di.modules;


import android.content.Context;

import aifree.com.citiestestapp.applicication.CitiesTestApplication;
import aifree.com.citiestestapp.data.repositories.RepositoryImpl;
import aifree.com.citiestestapp.domain.repositories.Repository;
import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private CitiesTestApplication mApplication;

    public ApplicationModule(CitiesTestApplication application) {
        mApplication = application;
    }

    @Provides
    public Context provideContext() {
        return mApplication;
    }

    @Provides
    public Repository provideRepository(RepositoryImpl repository) {
        return repository;
    }
}
