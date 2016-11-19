package aifree.com.citiestestapp.presentation.adapters.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import aifree.com.citiestestapp.R;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.FmtLikedViewController;


public class LikedHolder extends BaseHolder<City, FmtLikedViewController> {

    public LikedHolder(@NonNull Context context, FmtLikedViewController viewController) {
        super(context, viewController);
    }

    public LikedHolder(@NonNull View view, FmtLikedViewController viewController) {
        super(view, viewController);
    }

    @Override
    public BaseHolder<City, FmtLikedViewController> create(ViewGroup viewGroup) {
        View view = viewInflater(viewGroup, R.layout.v_liked_holder);
        return new LikedHolder(view, mViewController);
    }

    @Override
    public void bind(City dataModel) {
        TextView title = (TextView) mView.findViewById(R.id.v_liked_holder_title);
        ImageView liked = (ImageView) mView.findViewById(R.id.v_liked_holder_im_liked);
        liked.setOnClickListener(v -> mViewController.showUnlickedCityDialog(dataModel));
        title.setText(dataModel.getTitle());
    }
}