package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private final List<String> expectedListOfCatFood = List.of("Животные", "Птицы", "Рыба");
    private final String catSound = "Мяу";
    @Mock
    private Feline predator = new Feline();
    private Cat cat;
    @Before
    public void setUp() {
        this.cat = new Cat(predator);
    }

    @Test
    public void getSoundTest() {
        Assert.assertEquals(catSound, cat.getSound());
    }
    
    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(predator.eatMeat()).thenReturn(expectedListOfCatFood);
        List<String> actual = cat.getFood();
        Assert.assertEquals(expectedListOfCatFood, actual);
        Mockito.verify(predator, Mockito.times(1)).eatMeat();
    }
}