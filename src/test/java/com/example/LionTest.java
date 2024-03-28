package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private final List<String> expectedListOfGetFood = List.of("Животные", "Птицы", "Рыба");
    private final int expectedGetKittens = 1;
    private final boolean booleanMale = true;
    private final String male = "Самец";
    private final String female = "Самка";
    private final String unknownMale = "Неизвестный";
    private final String exceptionMaleMessage = "Используйте допустимые значения пола животного - самец или самка";
    
    @Mock
    private Feline feline = new Feline();
    
    private Lion lion;
    
    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(booleanMale, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals(expectedGetKittens, actual);
    }
    
    @Test
    public void doesHaveManeMaleMaleTest() throws Exception {
        lion = new Lion(male, feline);
        assertTrue(lion.doesHaveMane());
    }
    
    @Test
    public void doesHaveManeFemaleMaleTest() throws Exception {
        lion = new Lion(female, feline);
        assertFalse(lion.doesHaveMane());
    }
    
    @Test
    public void doesHaveManeUnknownMaleTest() {
        Exception exception = assertThrows(Exception.class, () -> lion = new Lion(unknownMale, feline));
        assertEquals(exceptionMaleMessage, exception.getMessage());
    }
    
    @Test
    public void getFoodLionTest() throws Exception {
        Lion lion = new Lion(booleanMale, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        assertEquals(expectedListOfGetFood, actual);
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}
