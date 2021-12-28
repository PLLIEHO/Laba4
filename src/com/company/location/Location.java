package com.company.location;

import com.company.human.CrewMember;
import com.company.human.Human;
import com.company.human.States;


import java.util.ArrayList;

import static com.company.location.LocationTypes.LADDER;

public class Location extends AbstractLocation implements ChangeLocation {
    private ArrayList<Human> humanList;
    private LocationTypes type;
    private ArrayList<Location> zerogravities = new ArrayList<>();

    public Location(LocationTypes type) {
        super(type);
        this.humanList = new ArrayList<>();

        System.out.println("Локация " + type + " создана. ");
        System.out.println(getDescription());
    }


    public void addHumanToLocation(Human human) {
        if (human.getState() != States.SLEEPY) {
            if (humanList.contains(human)) {
                System.out.println(human.getName() + " уже находится на локации " + getType());
            } else if (human instanceof CrewMember) {
                System.out.println("Человек " + human.getName() + " зашёл на локацию  " + getType());

                humanList.add(human);
            } else {
                System.out.println("Человек " + human.getName() + " не может зайти на локацию  " + getType() + ". Причина: Низкий уровень доступа.");
            }
        } else {System.out.println(human.getName() + " сейчас спит и никуда не пойдёт.");}
    }


    public void removeHumanToLocation(Human human) {
        if (human.getState() != States.SLEEPY) {
            if (humanList.contains(human) && walk(human)) {
                humanList.remove(human);
                System.out.println("Человек " + human.getName() + " покинул локацию " + getType());
            } else if ((humanList.contains(human) && !walk(human))) {
                humanList.remove(human);
                System.out.println("Человек " + human.getName() + " не может покинуть локацию " + getType());
            } else {
                System.out.println("Человека " + human.getName() + " здесь нет. Может, он в другом месте?");
            }
        } else {System.out.println(human.getName() + " сейчас спит и никуда не пойдёт.");}
    }


    public String getDescription() {
        String returns;
        if(getType() == LADDER) {
            returns = getType() + " - это тёмный коридор с уходщими вниз узкими ступенями.";
        }
        else if(getType() == LocationTypes.BRIDGE) {
            returns = getType() + " - это небольшая комната управления полётом. В иллюминатор видно удаляющуюся Землю.";
        }
        else if(getType() == LocationTypes.FOODFACILITY) {
            returns = getType() + " - это просторный склад, весь уставленный стелажами с ящиками. Тело пробирает холод.";
        }
        else{
            returns = "Неизвестная локация. Страшновато здесь.";
        }
        return returns;
    }

    private boolean walk(Human human) {
        if(humanList.contains(human)&&human instanceof CrewMember) {
            System.out.println(human + " проходит через локацию " + getType());
            return true;
        }
        else if (humanList.contains(human)){
            System.out.println(human + " не может пройти через локацию. Причина: низкий уровень доступа.");
            return false;
        }
        else{
            System.out.println("По локации никто не ходит, ведь там никого нет.");
            return false;
        }
    }


    public void gravityChange(){
        Gravity gravity = new Gravity();
        if(zerogravities.contains(this)) {
            gravity.gravityOn(this);
            zerogravities.remove(this);
        }
        else{
            gravity.gravityOff(this);
            zerogravities.add(this);
        }
    };

    public ArrayList<Location> getZerogravs() {
        return zerogravities;
    }

    public ArrayList<Human> getHumans() {
        return humanList;
    }
}