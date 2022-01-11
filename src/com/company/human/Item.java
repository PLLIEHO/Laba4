package com.company.human;

import java.util.ArrayList;

public enum Item {
    CHOP("Космическая котлета", 10),
    CHEESE("Космический сыр", 12),
    POTATO("Космическая картошка", 8),
    MEAT("Космическое мясо", 20),
    RISE("Космический рис", 6),
    CURD("Космический творог", 14),
    PIE("Космический пирог",30),
    CABBAGE("Космическая капуста", 7),
    SOUP("Космический суп", 18),
    SAUSAGE("Космическая сосиска", 5),;

    private final String name;
    private final int KKal;

    Item(String name, int KKal){
        this.name = name;
        this.KKal = KKal;
    }
    public int getKKal(){
        return KKal;
    }
    @Override
    public String toString() {
        return name;
    }

}