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
    private final List<String> EXPECTED_LIST_OF_GET_FOOD = List.of("Животные", "Птицы", "Рыба");
    private final int FELINE_DEFAULT_KITTENS = 1;
    @Spy
    private Feline feline;
    
    @Test
    public void eatMeatFelineTest() throws Exception {
        List<String> actual = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        assertEquals(actual, EXPECTED_LIST_OF_GET_FOOD);
    }
    
    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }
    
    @Test
    public void getKittensDefaultTest() {
        int actual = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals(actual, FELINE_DEFAULT_KITTENS);
    }
}