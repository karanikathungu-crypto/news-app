package dao;
import models.Departments;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;


public class Sql2oDepartmentsdaoTest {
    private Sql2oDepartmentsdao departmentsdao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "kenneth", "1234");
        departmentsdao = new Sql2oDepartmentsdao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingDepartmentSetsId() throws Exception {
        Departments testDepartment = setUpDepartments();
        int originalDepartmentsId = testDepartment.getId();
        assertNotEquals(originalDepartmentsId, testDepartment.getId());
    }

    @Test
    public void addedDepartmentsAreReturnedFromGetAll() throws Exception {
        Departments testDepartment = setUpDepartments();
        departmentsdao.add(testDepartment);
        assertEquals(1,departmentsdao.getAll().size());
    }

    public Departments setUpDepartments(){
        return new Departments("IT", 10);
    }
}
