package dao;
import models.User;
import org.sql2o.*;
import java.util.List;

public class Sql2oUsersdao implements Usersdao {

    Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/companynews","ken","1234");

    public Sql2oUsersdao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    public void add (User user){
        String sql = "INSERT INTO users (userName, companyPosition) VALUES (:userName, :companyPosition)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
                user.setId(id);
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<User>getAll(){
        try(Connection con = sql2o.open()){
           return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(User.class);

        }

    }

    @Override
    public User findById(int id){
        try(Connection con = sql2o.open()){
          return  con.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);

        }
    }

    @Override
    public void update(String userName, String companyPosition){
        String sql = "UPDATE users SET (userName, companyPosition) = (:userName, :companyPosition)";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("userName", userName)
                    .addParameter("position",companyPosition);
        }
    }

    @Override
    public void deleteById(int id){
        String sql = "DELETE from users WHERE id = :id";
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
        String sql = "DELETE from users";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }









}
