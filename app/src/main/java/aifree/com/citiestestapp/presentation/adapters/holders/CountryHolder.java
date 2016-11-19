package aifree.com.citiestestapp.presentation.adapters.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import aifree.com.citiestestapp.R;
import aifree.com.citiestestapp.presentation.models.Country;
import aifree.com.citiestestapp.presentation.screens.main.view_controllers.FmtCountryViewController;


public class CountryHolder extends BaseGroupHolder<Country, FmtCountryViewController> {

    public CountryHolder(@NonNull Context context, FmtCountryViewController viewController) {
        super(context, viewController);
    }


    public CountryHolder(@NonNull View view, FmtCountryViewController viewController) {
        super(view, viewController);
    }

    @Override
    public BaseGroupHolder<Country, FmtCountryViewController> create(ViewGroup viewGroup) {
        View view = viewInflater(viewGroup, R.layout.v_coutry_holder);
        return new CountryHolder(view, mViewController);
    }


    @Override
    public void bind(Country dataModel) {
        TextView title = (TextView) mView.findViewById(R.id.v_country_holder_tv_title);
        ImageView image = (ImageView) mView.findViewById(R.id.v_country_holder_im_image);
        title.setText(dataModel.getTitle());
        Picasso.with(mContext)
                .load(dataModel.getImageLink())
                .placeholder(R.drawable.ic_town)
                .error(R.drawable.ic_town)
                .into(image);
    }
}
