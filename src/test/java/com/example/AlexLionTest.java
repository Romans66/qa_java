package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {
    private final List<String> ALEX_FRIENDS = List.of("Зебра Марти", "Бегемотиха Глория" ,"Жираф Мелман");
    private final String ALEX_PLACE_OF_LIVING = "Нью-Йоркский зоопарк";
    private final int ALEX_KITTENS = 0;
    @Spy
    private Feline feline;
    @Spy
    private AlexLion alexLion;
    
    @Before
    public void setUp() {
        alexLion = new AlexLion(feline);
    }
    
    @Test
    public void getFriends() {
        List<String> actual = alexLion.getFriends();
        assertEquals(actual, ALEX_FRIENDS);
    }
    
    @Test
    public void getPlaceOfLiving() {
        String actual = alexLion.getPlaceOfLiving();
        assertEquals(actual, ALEX_PLACE_OF_LIVING);
    }
    
    @Test
    public void getKittensAlexTest() {
        int actual = alexLion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(0);
        assertEquals(actual, ALEX_KITTENS);
    }
}