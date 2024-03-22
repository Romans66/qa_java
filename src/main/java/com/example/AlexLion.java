package com.example;

import java.util.List;

public class AlexLion extends Lion {
    private Feline feline;
    
    public AlexLion(Feline feline) {
        super(true, feline);
        this.feline = feline;
    }
    
    public AlexLion() throws Exception {
        super("Самец");
    }
    
    public List<String> getFriends() {
        return List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");
    }
    
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
    
    @Override
    public int getKittens() {
        return feline.getKittens(0);
    }
}
