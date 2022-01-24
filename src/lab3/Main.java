package lab3;

import lab3.human.*;
import lab3.location.Conversation;
import lab3.location.Location;
import lab3.location.LocationTypes;
import lab3.human.*;
import lab3.location.TimeSkip;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Ponchik ponchik = new Ponchik("Пончик", 9, States.HUNGRY);
        Passenger spy = new Passenger("Вася", 20, States.NOTHUNGRY);
        Passenger viktor = new Passenger("Виктор", 20, States.NOTHUNGRY);
        Passenger vitalya = new Passenger("Виталя", 20, States.NOTHUNGRY);
        Location bridge = new Location(LocationTypes.BRIDGE);
        Location bridge1 = new Location(LocationTypes.BRIDGE);
        Location room = new Location(LocationTypes.ROOM);
        TimeSkip.incPhase();
        bridge.addHumanToLocation(vitalya);
        room.addHumanToLocation(spy);
        room.addHumanToLocation(vitalya);
        room.addHumanToLocation(viktor);
        room.addHumanToLocation(ponchik);
        spy.tellTheStory(room);
        IJoke joker = new IJoke(){
            public void joke(Location location){
                int isFunny = new Random().nextInt(2);
                for(int i = 0; i<location.getHumans().size(); i++){
                    location.getHumans().get(i).smile(isFunny);
                }
                TimeSkip.incTime(180);
            }
        };
        joker.joke(room);

        viktor.tellTheStory(room);
        joker.joke(room);
        room.gravityChange();
        spy.sleep(room, 10);
        viktor.sleep(room, 10);
        vitalya.sleep(room, 10);
        ponchik.sleep(room, 10);
        System.out.println();
        ponchik.eatFromBag(3);
        IHear iHear;
        iHear = (o) -> {
            return o instanceof Human || o instanceof Conversation||(o instanceof Location && ((Location) o).getType() != LocationTypes.LADDER);
        };
        ponchik.canBeListened(iHear.hear(room), room);
        Conversation convers = new Conversation(viktor, spy, room);
        ponchik.canBeListened(iHear.hear(convers), convers);
    }
}