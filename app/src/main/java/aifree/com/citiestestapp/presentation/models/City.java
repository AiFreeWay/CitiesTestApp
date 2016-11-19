package aifree.com.citiestestapp.presentation.models;


import java.io.Serializable;

public class City implements Serializable {

    private int Id;
    private String Name;

    public City() {
    }

    public City(int id, String name) {
        this.Id = id;
        this.Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getTitle() {
        return Name;
    }

    public void setTitle(String name) {
        this.Name = name;
    }
}
