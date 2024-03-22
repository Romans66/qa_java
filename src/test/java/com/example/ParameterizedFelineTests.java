package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;

@RunWith(Parameterized.class)
public class ParameterizedFelineTests {
    private int getKittensExpectedValue;
    private int expected;
    private Feline feline = new Feline();
    @Spy
    private Feline felineSpy = Mockito.spy(feline);
    
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
        int actual = felineSpy.getKittens(getKittensExpectedValue);
        Mockito.verify(felineSpy).getKittens(Mockito.anyInt());
        Assert.assertEquals(actual, getKittensExpectedValue);
    }
    
}
