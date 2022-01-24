package lab3.human;

import java.util.ArrayList;

public enum Item {
    CHOP("Космическая котлета", 10),
    CHEESE("Космический сыр", 12),
    POTATO("Космическая картошка", 8),
    MEAT("Космическое мясо", 20),
    BREAD("Космический хлеб", 6),
    CURD("Космический творог", 14),
    PIE("Космический пирог",30),
    SAUSAGE2("Космическая колбаса", 7),
    SOUP("Космический суп", 18),
    SAUSAGE("Космическая сосиска", 5);

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