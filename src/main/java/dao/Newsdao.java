package dao;

import models.Departments;
import models.News;

import java.util.List;

public interface Newsdao {
    void add (News news);//create
//    void addNewsToDepartments( News news, Departments departments);

    List<News> getAll();

    News findById(int id);

//    List<News> getAllDepartmentsForNews(int departmentsId);

    //update
    void update( int id, String headline, String information);

    //delete
    void deleteById(int id);

    void clearAll();

}
