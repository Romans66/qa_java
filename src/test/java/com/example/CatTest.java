package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Feline feline = new Feline();
    @Spy
    private Cat cat = new Cat(feline);
    
    @Test
    public void getSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }
    
    @Test
    public void getFood() throws Exception {
        cat.getFood();
        Mockito.verify(cat, Mockito.times(1)).getFood();
    }
}