package dao;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;


public class Sql2oUsersdaoTest {

    private Sql2oUsersdao usersdao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "kenneth", "1234");
        usersdao = new Sql2oUsersdao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingUserSetsId() throws Exception {
        User testUser = setUpUser();
        int originalUserId = testUser.getId();
        usersdao.add(testUser);
        assertNotEquals(originalUserId, testUser.getId());
    }

    @Test
    public void addedUsersAreReturnedFromGetAll() throws Exception {
        User testUser = setUpUser();
        usersdao.add(testUser);
        assertEquals(1, usersdao.getAll().size());
    }

    public User setUpUser(){
        return new User("Mark","Supervisor");
    }
}
