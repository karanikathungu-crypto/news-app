package models;

import java.util.Objects;

public class News {
    private String headline;
    private String departmentName;
    private int id;

    public News(String headline){
        this.headline = headline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departments)) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(headline, news.headline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, headline, id);
    }
}

