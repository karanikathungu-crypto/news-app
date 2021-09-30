package dao;
import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;


public class Sql2oNewsdaoTest {
    private Sql2oNewsdao newsdao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "kenneth", "1234");
        newsdao = new Sql2oNewsdao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingNewsSetsId() throws Exception {
        News testNews = setUpNews();
        int originalNewsId = testNews.getId();
        newsdao.add(testNews);
        assertNotEquals(originalNewsId, testNews.getId());
    }

    @Test
    public void addedNewsAreAllReturnedFromGetAll() throws Exception{
        News testNews = setUpNews();
        newsdao.add(testNews);
        assertEquals(1, newsdao.getAll().size());
    }

    public News setUpNews(){
        return new News("new dress code", "Company implements new dress code");
    }
}
