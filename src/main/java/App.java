import com.google.gson.Gson;
import dao.Sql2oDepartmentsdao;
import dao.Sql2oNewsdao;
import dao.Sql2oUsersdao;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;



public class App {
    public static void main(String[] args) {
        Sql2oUsersdao Usersdao;
        Sql2oNewsdao Newsdao;
        Sql2oDepartmentsdao Departmentsdao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/newsapp.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString,"kenneth","1234");

        Usersdao = new Sql2oUsersdao(sql2o);
        Departmentsdao = new Sql2oDepartmentsdao(sql2o);
        Newsdao = new Sql2oNewsdao(sql2o);
//        conn = sql2o.open();

        post("/Departments/new", "application/json", (req, res) -> {
            Departments departments = gson.fromJson(req.body(), Departments.class);
            Departmentsdao.add(departments);
            res.status(201);
            res.type("application/json");
            return gson.toJson(departments);
        });
        get("/Departments", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(Departmentsdao.getAll());
        });

        get("/Departments/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(Departmentsdao.findById(id));
        });

        post("/News/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            Newsdao.add(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });
        get("/News", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(Newsdao.getAll());
        });

        get("/News/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(Newsdao.findById(id));
        });

//
        post("/Users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            Usersdao.add(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });
        get("/Users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(Usersdao.getAll());
        });

        get("/Users/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(Usersdao.findById(id));
        });






    }
}
