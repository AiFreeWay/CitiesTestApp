package aifree.com.citiestestapp.data.models;

import aifree.com.citiestestapp.presentation.models.City;


public class CountryData {

    private int id;
    private City[] Cities;
    private String Name;
    private String ImageLink;

    public CountryData() {
    }

    public CountryData(int id, City[] cities, String name, String imageLink) {
        this.id = id;
        Cities = cities;
        Name = name;
        ImageLink = imageLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City[] getCities() {
        return Cities;
    }

    public void setCities(City[] cities) {
        Cities = cities;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }
}
