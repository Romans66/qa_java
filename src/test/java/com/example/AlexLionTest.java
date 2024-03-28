package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {
    private final List<String> alexFriends = List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");
    private final String alexPlaceOfLiving = "Нью-Йоркский зоопарк";
    private final int alexKittens = 0;
    @Mock
    private Feline feline;
    
    private AlexLion alexLion;
    
    @Before
    public void setUp() {
        alexLion = new AlexLion(feline);
    }
    
    @Test
    public void getFriends() {
        List<String> actual = alexLion.getFriends();
        assertEquals(alexFriends, actual);
    }
    
    @Test
    public void getPlaceOfLiving() {
        String actual = alexLion.getPlaceOfLiving();
        assertEquals(alexPlaceOfLiving, actual);
    }
    
    @Test
    public void getKittensAlexTest() {
        Mockito.when(feline.getKittens(0)).thenReturn(0);
        int actual = alexLion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(0);
        assertEquals(alexKittens, actual);
    }
}