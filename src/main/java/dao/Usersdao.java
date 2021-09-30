package dao;

import models.Departments;
import models.News;
import models.User;


import java.util.List;

public interface Usersdao {
    void add (User user);//create

    List<User> getAll();

    User findById(int id);


    //update
    void update( String userName, String position);

    //delete
    void deleteById(int id);

    void clearAll();

}
