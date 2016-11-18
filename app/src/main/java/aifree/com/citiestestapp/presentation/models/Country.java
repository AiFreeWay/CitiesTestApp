package aifree.com.citiestestapp.presentation.models;

import android.os.Parcel;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;



public class Country extends ExpandableGroup {

    public Country(String title, List items) {
        super(title, items);
    }

    protected Country(Parcel in) {
        super(in);
    }
}
