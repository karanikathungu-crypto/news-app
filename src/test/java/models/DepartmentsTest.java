package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DepartmentsTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getDepartmentNameReturnsCorrectName() {
        Departments testDepartment = setUpDepartments();
        assertEquals("IT",testDepartment.getDepartmentName());

    }

    @Test
    public void getStaffNumberReturnsCorrectNumber() {
        Departments testDepartment = setUpDepartments();
        assertEquals(10, testDepartment.getStaffNumber());
    }


    public Departments setUpDepartments(){
        return new Departments("IT",10);
    }
}
