package lab3;

import lab3.human.*;
import lab3.location.Location;
import lab3.location.LocationTypes;
import lab3.human.*;

public class Main {

    public static void main(String[] args) {
        Location bridge = new Location(LocationTypes.BRIDGE);
        Human neznayka = new CrewMember("Незнайка", 10, States.NOTHUNGRY);
        Human ponchik = new CrewMember("Пончик", 9, States.HUNGRY);
        Human spy = new Human("Незнакомец", 20, States.NOTHUNGRY);
        System.out.println();

        bridge.addHumanToLocation(neznayka);
        bridge.addHumanToLocation(ponchik);
        bridge.addHumanToLocation(spy);
        bridge.removeHumanToLocation(neznayka);
        bridge.removeHumanToLocation(ponchik);
        System.out.println();

        Location ladder = new Location(LocationTypes.LADDER);
        ladder.addHumanToLocation(neznayka);
        ladder.addHumanToLocation(ponchik);
        ladder.removeHumanToLocation(neznayka);
        ladder.removeHumanToLocation(ponchik);
        System.out.println();

        Location food = new Location(LocationTypes.FOODFACILITY);
        food.addHumanToLocation(neznayka);
        food.addHumanToLocation(ponchik);
        System.out.println();

        Item chop = Item.CHOP;
        System.out.println();
        System.out.println(neznayka.getDescription());
        neznayka.eat(chop);
        neznayka.eat(chop);

        System.out.println();
        System.out.println(ponchik.getDescription());
        ((CrewMember) ponchik).declare(food);
        for (int i = 0; i < 11; i++) {
            ((CrewMember) ponchik).randomEat();
            FoodCheckable checker = x -> {
                int var = 10 - x;
                return "Можно съесть ещё " + var + " блюд";
            };
            System.out.println(checker.compare(i));
        }
        System.out.println(ponchik.getDescription());
        food.gravityChange();
        ponchik.sleep(food, 10);
        food.removeHumanToLocation(ponchik);
        System.out.println(ponchik.getDescription());
        ponchik.wakeUp();
        food.removeHumanToLocation(ponchik);
        food.removeHumanToLocation(neznayka);
    }
}