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
        String sql = "INSERT INTO departments (departmentName, staffNumber) VALUES (:departmentName, :staffNumber)";
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
    public Departments findById(int id) {
       try (Connection con = sql2o.open()) {
           return con.createQuery("SELECT * FROM departments WHERE id = :id")
                   .addParameter("id", id)
                   .executeAndFetchFirst(Departments.class);

       }
   }
    @Override
    public void update(int id, String departmentName, int staffNumber){
           String sql = "UPDATE departments SET (departmentName, staffNumber) = (:departmentName, :staffNumber) WHERE id = :id";
           try(Connection con = sql2o.open()){
               con.createQuery(sql)
                       .addParameter("departmentName", departmentName)
                       .addParameter("staffNumber", staffNumber)
                       .addParameter("id", id);
           }
       }
    public void deleteById(int id){
       String sql = "DELETE from departments WHERE id = :id";
       try(Connection con = sql2o.open()){
           con.createQuery(sql)
                   .addParameter("id", id)
                   .executeUpdate();
       } catch (Sql2oException ex){
           System.out.println(ex);
       }
    }

    @Override
    public void clearAll(){
       String sql = "DELETE from departments";
       try(Connection con = sql2o.open()){
           con.createQuery(sql).executeUpdate();
       } catch(Sql2oException ex){
           System.out.println(ex);
       }
    }





}
