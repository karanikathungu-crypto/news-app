package models;

public class News {
    private String headline;
    private String departmentName;

    public News(String headline){
        this.headline = headline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}
