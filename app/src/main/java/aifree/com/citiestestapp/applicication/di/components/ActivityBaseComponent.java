package aifree.com.citiestestapp.applicication.di.components;

import aifree.com.citiestestapp.applicication.di.modules.ActivityBaseModule;
import aifree.com.citiestestapp.applicication.di.scopes.PerActivity;
import aifree.com.citiestestapp.domain.repositories.Repository;
import aifree.com.citiestestapp.presentation.screens.launcher.view_controllers.AcLauncherViewController;
import dagger.Component;

@PerActivity
@Component(modules = ActivityBaseModule.class, dependencies = ApplicationComponent.class)
public interface ActivityBaseComponent {

    void inject(AcLauncherViewController controller);

    Repository provideRepository();
}
