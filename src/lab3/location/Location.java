package lab3.location;

import lab3.exceptions.DoubleBridgesException;
import lab3.human.CrewMember;
import lab3.human.Human;
import lab3.human.States;


import java.util.ArrayList;
import java.util.List;

import static lab3.location.LocationTypes.*;

public class Location extends AbstractLocation implements ChangeLocation {
    private List<Human> humanList = new ArrayList<>();
    private LocationTypes type;
    private static List<Location> zerogravities = new ArrayList<>();
    private List<Shelves.Bed> beds = new ArrayList<Shelves.Bed>();
    private static List<Location> locations = new ArrayList<>();

    public Location(LocationTypes type) {
        super(type);
        System.out.println("Локация " + type + " создана. ");
        System.out.println(getDescription());
        locations.add(this);
        try {
            locationChecker();
        } catch (DoubleBridgesException e){
            for(int i = 0; i <= locations.size()-1; i++){
                if(locations.get(i).getType()==LocationTypes.BRIDGE){
                    locations.remove(i);
                    this.type = VOID;
                    System.out.println("Дубликат мостика уничтожен.");
                    break;
                }
            }
        }
    }


    public class Shelves{
        protected Shelves(){
            this.bedMaker();
            System.out.println(Location.this.getType() + ": полки выдвинулись из стен, можно спать.");
        }
        public class Bed{
            private boolean isFree = true;
            private Bed(){
            }
            public boolean getFree(){
                return isFree;
            }
            public void setFree(boolean isFree){
                this.isFree = isFree;
            }
        }
        private void bedMaker(){
            if (Location.this.getType()==LocationTypes.ROOM){
                for(int i=0; i <= Location.this.getHumans().size(); i++){
                    beds.add(new Bed());
                }
                //Bed bed1 = new Bed();
                //Bed bed2 = new Bed();
                //Bed bed3 = new Bed();
                //Bed bed4 = new Bed();
                //beds.add(bed1); beds.add(bed2); beds.add(bed3); beds.add(bed4);
            }
        }
    }

    public void addHumanToLocation(Human human) {
        if (human.getState() != States.SLEEPY) {
            if (humanList.contains(human)) {
                System.out.println(human.getName() + " уже находится на локации " + getType());
            } else if ((human instanceof CrewMember||this.getType()==ROOM)&&this.type!=VOID) {
                System.out.println("Человек " + human.getName() + " зашёл на локацию  " + getType());
                humanList.add(human);
                human.setCurrentLocation(this);
            } else if(this.type!=VOID){
                System.out.println("Человек " + human.getName() + " не может зайти на локацию  " + getType() + ". Причина: Низкий уровень доступа.");
            } else {
                System.out.println("Этой локации не существует. Проверьте данные.");
            }
        } else {System.out.println(human.getName() + " сейчас спит и никуда не пойдёт.");}
    }


    public void removeHumanToLocation(Human human) {
        if (human.getState() != States.SLEEPY) {
            if (humanList.contains(human) && walk(human)) {
                humanList.remove(human);
                System.out.println("Человек " + human.getName() + " покинул локацию " + getType());
                human.setCurrentLocation(null);
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
        else if(getType() == LocationTypes.ROOM){
            returns = getType() + " - это маленькая комната, на стенах которой закреплены кровати, которые выдвигаются с наступлением темноты.";
        }
        else{
            returns = "Пустота. Раньше здесь была локация, но, похоже, она исчезла. Что же здесь случилось?";
        }
        return returns;
    }

    private boolean walk(Human human) {
        if(humanList.contains(human)&&(human instanceof CrewMember||this.getType()==LocationTypes.ROOM)) {
            System.out.println(human + " проходит через локацию " + getType());
            return true;
        }
        else if (humanList.contains(human)&&this.getType()!=LocationTypes.ROOM){
            System.out.println(human + " не может пройти через локацию. Причина: низкий уровень доступа.");
            return false;
        }
        else{
            System.out.println("По локации никто не ходит, ведь там никого нет.");
            return false;
        }
    }

    public static void locationChecker() throws DoubleBridgesException{
        for(int i =0; i<=locations.size()-2; i++){
            for(int e = i+1; e<=locations.size()-1; e++){
                if(locations.get(i).getType()==locations.get(e).getType()&&locations.get(i).getType()==LocationTypes.BRIDGE){
                    throw new DoubleBridgesException("Ошибка: обнаружено два мостика. Кораблей с двумя мостиками не существует, он должен быть один.");
                }
            }
        }
    }

    public void gravityChange(){
        Gravity gravity = new Gravity();
        if(this.type!=VOID) {
            if (zerogravities.contains(this)) {
                gravity.gravityOn(this);
                zerogravities.remove(this);
            } else {
                gravity.gravityOff(this);
                zerogravities.add(this);
            }
        } else {
            System.out.println("В пустоте гравитации не существует...");
        }
    };

    public List<Location> getZerogravs() {
        return zerogravities;
    }

    public List<Shelves.Bed> getBeds() {
        return beds;
    }

    public List<Human> getHumans() {
        return humanList;
    }

    public static List<Location> getLocations() {
        return locations;
    }
}