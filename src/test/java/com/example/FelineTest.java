package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private final List<String> expectedListOfGetFood = List.of("Животные", "Птицы", "Рыба");
    private final int felineDefaultKittens = 1;
    private final String felineFamily = "Кошачьи";
    @Spy
    private Feline feline;
    
    @Test
    public void eatMeatFelineTest() throws Exception {
        List<String> actual = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        assertEquals(expectedListOfGetFood, actual);
    }
    
    @Test
    public void getFamilyTest() {
        Assert.assertEquals(felineFamily, feline.getFamily());
    }
    
    @Test
    public void getKittensDefaultTest() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        int actual = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals(felineDefaultKittens, actual);
    }
}