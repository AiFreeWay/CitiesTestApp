package aifree.com.citiestestapp.presentation.screens.launcher.view_controllers;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import aifree.com.citiestestapp.presentation.screens.main.activities.MainActivity;
import aifree.com.citiestestapp.presentation.screens.commons.base_components.ViewController;
import aifree.com.citiestestapp.presentation.screens.launcher.activities.LauncherActivity;
import aifree.com.citiestestapp.presentation.utils.Logger;
import aifree.com.citiestestapp.presentation.utils.ScreensRouter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;


public class AcLauncherViewController extends ViewController<LauncherActivity> {

    @Inject
    ScreensRouter mRouter;

    public AcLauncherViewController(LauncherActivity view) {
        super(view);
        mView.getActivityComponent()
                .inject(this);
    }

    @Override
    public void start() {
        super.start();
        Observable.timer(1800, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(mView::startAnimation)
                .subscribe(time -> mRouter.showActivityClearTask(MainActivity.class), Logger::logError);
    }
}
