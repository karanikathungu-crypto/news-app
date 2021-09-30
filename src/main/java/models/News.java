package models;

import java.util.Objects;

public class News {
    private String headline;
    private String information;
    private String departmentName;
    private int id;



    public News(String headline, String information){

        this.headline = headline;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(headline, news.headline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, headline, id);
    }
}

