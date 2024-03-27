package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private final List<String> expectedListOfCatFood = List.of("Животные", "Птицы", "Рыба");
    private Feline feline = new Feline();
    private Cat cat = new Cat(feline);
    
    @Test
    public void getSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }
    
    @Test
    public void getFood() throws Exception {
        List<String> actual = cat.getFood();
        Assert.assertEquals(expectedListOfCatFood, actual);
    }
}