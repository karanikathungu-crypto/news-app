package models;

import java.util.Objects;

public class User {
    private String userName;
    private String companyPosition;
    private int id;

    public User(String userName, String companyPosition){
        this.userName = userName;
        this.companyPosition = companyPosition;
    }

    public String getCompanyPosition() {
        return companyPosition;
    }

    public void setCompanyPosition(String companyPosition) {
        this.companyPosition = companyPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName)&&
                Objects.equals(companyPosition, user.companyPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName , companyPosition, id);
    }



}

