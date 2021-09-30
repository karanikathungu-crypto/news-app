package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NewsTest {

    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void getHeadlineReturnsCorrectHeadline() {
        News testNews = setUpNews();
        assertEquals("New dress code", testNews.getHeadline());
    }

    @Test
    public void getInformationReturnsCorrectInformation() {
        News testNews = setUpNews();
        assertEquals("The company has implemented new dress code changes", testNews.getInformation());

    }

    public News setUpNews(){
        return new News("New dress code", "The company has implemented new dress code changes");
    }
}
