package aifree.com.citiestestapp.presentation.screens.launcher.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import aifree.com.citiestestapp.R;
import aifree.com.citiestestapp.presentation.screens.commons.base_components.BaseActivity;
import aifree.com.citiestestapp.presentation.screens.launcher.view_controllers.AcLauncherViewController;


public class LauncherActivity extends BaseActivity<AcLauncherViewController> {

    private ImageView mImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_launcher);
        bindViews();
        mViewControler = new AcLauncherViewController(this);
        mViewControler.start();
    }

    public void startAnimation() {
        float scaleValue = (float) 0.4;
        mImage.animate()
                .scaleXBy(scaleValue)
                .scaleYBy(scaleValue)
                .setDuration(1000)
                .start();
    }

    private void bindViews() {
        mImage = (ImageView) findViewById(R.id.ac_launcher_iv_logo);
    }
}
