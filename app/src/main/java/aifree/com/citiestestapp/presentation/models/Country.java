package aifree.com.citiestestapp.presentation.models;

import android.os.Parcel;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;



public class Country extends ExpandableGroup {

    private int id;
    private String ImageLink;


    public Country(int id, String title, List items, String ImageLink) {
        super(title, items);
        this.id = id;
        this.ImageLink = ImageLink;
    }

    protected Country(Parcel in) {
        super(in);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }
}
