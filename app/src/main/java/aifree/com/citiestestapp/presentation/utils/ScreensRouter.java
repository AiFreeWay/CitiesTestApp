package aifree.com.citiestestapp.presentation.utils;


import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

public class ScreensRouter {

    private Context mContext;

    @Inject
    public ScreensRouter(Context context) {
        mContext = context;
    }

    public void showActivityClearTask(Class activityClass) {
        Intent intent = new Intent(mContext, activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
