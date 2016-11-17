package aifree.com.citiestestapp.applicication.di.components;

import android.content.Context;

import javax.inject.Singleton;

import aifree.com.citiestestapp.applicication.di.modules.ApplicationModule;
import aifree.com.citiestestapp.domain.repositories.Repository;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context provideContext();
    Repository provideRepository();
}
