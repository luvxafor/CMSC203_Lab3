package lab3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GradeBookTester
{
    private GradeBook gradeBook1;
    private GradeBook gradeBook2;

    @Before
    public void setUp() throws Exception
    {
        gradeBook1 = new GradeBook(5);
        gradeBook2 = new GradeBook(5);
        
        gradeBook1.addScore(85.0);
        gradeBook1.addScore(90.0);

        gradeBook2.addScore(75.0);
        gradeBook2.addScore(80.0);
        gradeBook2.addScore(70.0);
    }

    @After
    public void tearDown() throws Exception
    {
        gradeBook1 = null;
        gradeBook2 = null;
    }

    @Test
    public void testAddScore()
    {
        assertTrue(gradeBook1.toString().equals("85.0 90.0"));
        assertEquals(2, gradeBook1.getScoreSize());

        assertTrue(gradeBook2.toString().equals("75.0 80.0 70.0"));
        assertEquals(3, gradeBook2.getScoreSize());
    }

    @Test
    public void testSum()
    {
        assertEquals(175.0, gradeBook1.sum(), 0.001);
        assertEquals(225.0, gradeBook2.sum(), 0.001);
    }

    @Test
    public void testMinimum()
    {
        assertEquals(85.0, gradeBook1.minimum(), 0.001);
        assertEquals(70.0, gradeBook2.minimum(), 0.001);
    }

    @Test
    public void testFinalScore()
    {
        assertEquals(90.0, gradeBook1.finalScore(), 0.001); // 175 - 85
        assertEquals(155.0, gradeBook2.finalScore(), 0.001); // 225 - 70
    }
}