package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedFelineTests {
    private int getKittensExpectedValue;
    private int expected;
    private Feline feline = new Feline();
    
    public ParameterizedFelineTests(int getKittensExpectedValue, int expected) {
        this.getKittensExpectedValue = getKittensExpectedValue;
        this.expected = expected;
    }
    
    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {0, 0},
                {99999, 99999},
                {-1, -1},
                {-99999, -99999},
                {1, 1},
        };
    }
    
    @Test
    public void getKittensTest() {
        int actual = feline.getKittens(getKittensExpectedValue);
        Assert.assertEquals(getKittensExpectedValue, actual);
    }
    
}
