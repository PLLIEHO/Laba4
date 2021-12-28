package com.company.human;

import java.util.ArrayList;
import java.util.Random;

public class Revision {
    private Item item;
    private static ArrayList<Item> items = new ArrayList<Item>();
    public Revision() {
        if (items.size() == 0) {
            items.add(Item.CHOP);
            items.add(Item.CHEESE);
            items.add(Item.POTATO);
            items.add(Item.CURD);
            items.add(Item.CABBAGE);
            items.add(Item.MEAT);
            items.add(Item.RISE);
            items.add(Item.PIE);
            items.add(Item.SOUP);
            items.add(Item.SAUSAGE);

        }
    }

    static Item revisionStep(int capac, Stomach stomach, CrewMember crewMember){
        Item item;
        if(capac>0) {
            int rand = new Random().nextInt(items.size()-1);
            item = items.get(rand);
            items.remove(rand);
        }
        else{
            item = items.get(0);
        }
        boolean flag = stomach.consume(item);
        if(flag){
            crewMember.incWeight();
        }
        return item;
    }
}