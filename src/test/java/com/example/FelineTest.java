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
        Assert.assertEquals(feline.getFamily(), "Кошачьи");
    }
    
    @Test
    public void getKittensDefaultTest() {
        int actual = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals(felineDefaultKittens, actual);
    }
}