package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private final List<String> EXPECTED_LIST_OF_GET_FOOD = List.of("Животные", "Птицы", "Рыба");
    private final int EXPECTED_GET_KITTENS = 1;
    private final boolean BOOLEAN_MALE = true;
    private final String MALE = "Самец";
    private final String FEMALE = "Самка";
    private final String UNKNOWN_MALE = "Неизвестный";
    private final String exceptionMaleMessage = "Используйте допустимые значения пола животного - самец или самка";
    
    @Spy
    private Feline feline = new Feline();
    @Spy
    private Lion lion = new Lion(BOOLEAN_MALE, feline);
    
    
    @Test
    public void getKittensTest() throws Exception {
        int actual = lion.getKittens();
        assertEquals(EXPECTED_GET_KITTENS, actual);
    }
    
    @Test
    public void doesHaveManeMaleMaleTest() throws Exception {
        lion = new Lion(MALE);
        assertTrue(lion.doesHaveMane());
    }
    
    @Test
    public void doesHaveManeFemaleMaleTest() throws Exception {
        lion = new Lion(FEMALE);
        assertFalse(lion.doesHaveMane());
    }
    
    @Test
    public void doesHaveManeUnknownMaleTest() {
        Exception exception = assertThrows(Exception.class, () -> lion = new Lion(UNKNOWN_MALE));
        assertEquals(exceptionMaleMessage, exception.getMessage());
    }
    
    @Test
    public void getFood() throws Exception {
        List<String> actual = lion.getFood();
        Mockito.verify(lion, Mockito.times(1)).getFood();
        assertEquals(actual, EXPECTED_LIST_OF_GET_FOOD);
        
    }
}
