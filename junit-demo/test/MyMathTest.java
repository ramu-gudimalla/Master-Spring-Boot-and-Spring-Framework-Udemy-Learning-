package test;

import org.junit.Assert;
import org.junit.MyMath;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyMathTest {
    // Absence of failure is success
    // Test condition or Assert
    private final MyMath math = new MyMath();
    @Test
    public void calculateThreeMemberArray() {
        assertEquals(10, math.calculateSum(new int[]{1,2,3,4}));
    }
    @Test
    public void calculateZeroLengthArray() {
        assertEquals(0, math.calculateSum(new int[]{}));
    }
}
