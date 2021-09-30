package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void getNameReturnsCorrectName() {
        User testUser = setUpUser();
        assertEquals("Mark", testUser.getName());

    }

    @Test
    public void getCompanyPositionReturnsCorrectCompanyPosition() {
        User testUser = setUpUser();
        assertEquals("Supervisor", testUser.getCompanyPosition());
    }

    public User setUpUser(){
        return new User("Mark", "Supervisor");
    }
}
