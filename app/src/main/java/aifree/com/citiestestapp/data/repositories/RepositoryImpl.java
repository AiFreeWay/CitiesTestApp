package aifree.com.citiestestapp.data.repositories;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import aifree.com.citiestestapp.domain.repositories.Repository;

@Singleton
public class RepositoryImpl implements Repository {

    @Inject
    public RepositoryImpl(Context context) {
    }
}
