package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private final List<String> expectedListOfCatFood = List.of("Кити-кэт");
    private Feline feline = new Feline();
    @Mock
    private Cat cat = new Cat(feline);
    
    @Test
    public void getSound() {
        Mockito.when(cat.getSound()).thenReturn("Мяу");
        Assert.assertEquals(cat.getSound(), "Мяу");
    }
    
    @Test
    public void getFood() throws Exception {
        Mockito.when(cat.getFood()).thenReturn(expectedListOfCatFood);
        List<String> actual = cat.getFood();
        Assert.assertEquals(expectedListOfCatFood, actual);
    }
}