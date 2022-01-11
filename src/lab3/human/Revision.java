package lab3.human;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Revision {
    private static List<Item> items = new ArrayList<>();
    public Revision() {
        if (items.size() == 0) {
            for(Item item : Item.values()){
                items.add(item);
            }
        }

    }

    public static Item revisionStep(int capac, Stomach stomach, CrewMember crewMember){
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