package dao;

import models.Departments;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsdao implements Newsdao{

    Sql2o sql2o= new Sql2o("jdbc:postgresql://localhost:5432/companynews","ken","1234");

    public Sql2oNewsdao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(News news){
        String sql = "INSERT INTO news (headline, information) VALUES (:headline, :information)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAll(){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);

        }
    }

    @Override
    public void update(int id, String headline, String information){
        String sql = "UPDATE news SET (headline, information) = (:headline, :information) WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("headline", headline)
                    .addParameter("information", information)
                    .addParameter("id", id);
        }
    }
    @Override
    public void deleteById(int id){
        String sql = "DELETE from news WHERE id = :id";
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
        String sql = "DELETE from news";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }






}
