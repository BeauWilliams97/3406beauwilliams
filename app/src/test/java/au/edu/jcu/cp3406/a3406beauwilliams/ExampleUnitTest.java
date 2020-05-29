package au.edu.jcu.cp3406.a3406beauwilliams;

import android.view.View;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void monthsCalculation() {
        double expectedResult = 0.5;
        double inches = 0.5;
        int growTime = 1;
        double result = growTime * inches;
        assertTrue(expectedResult == result);

    }
    @Test
    public  void cmCalculation(){
        double expectedResult = 1.27;
        double centimeters = 1.27;
        int growTime = 1;
        double result = growTime * centimeters;
        assertTrue(expectedResult == result);

    }
    @Test
    public void resetClick(){

    }
}