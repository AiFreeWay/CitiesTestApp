package aifree.com.citiestestapp.presentation.models;


public class City {

    private int id;
    private String title;

    public City() {
    }

    public City(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
