package dao;


import com.sun.org.apache.bcel.internal.generic.NEW;
import models.Departments;
import models.News;

import java.util.List;


public interface Departmentsdao {

    void add (Departments departments);//create
    void addDepartmentsToNews(Departments departments, News news);

    List<Departments> getAll();

    Departments findById(int id);

    List<News> getAllNewsForDepartment(int departmentsId);

    //update
    void update(int id, String departmentName, int staffNumber);

    //delete
    void deleteById(int id);

    void clearAll();



}
