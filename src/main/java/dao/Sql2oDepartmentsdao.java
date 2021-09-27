package dao;
import models.Departments;
import org.sql2o.*;
import java.util.List;

public class Sql2oDepartmentsdao implements Departmentsdao {

//   private final Sql2o sql2o;
    Sql2o sql2o= new Sql2o("jdbc:postgresql://localhost:5432/companynews","ken","1234");

   public Sql2oDepartmentsdao(Sql2o sql2o){
       this.sql2o = sql2o;
   }

   @Override
    public void add(Departments departments){
        String sql = "INSERT INTO departments (departmentName, staffNumber) VALUES (:departmentName, :staffNumber");
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
   }

   @Override
    public List<Departments>getAll(){
       try (Connection con = sql2o.open()){
           return con.createQuery("SELECT * FROM departments")
                   .executeAndFetch(Departments.class);
       }
   }

   @Override
    public Departments findById(int id){
       try (Connection con = sql2o.open()){
           return con.createQuery("SELECT * FROM departments WHERE id = :id")
                   .addParameter("id", id)
                   .executeAndFetchFirst(Departments.class);

       }
   @Override

   }




}
