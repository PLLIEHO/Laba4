package lab3.location;

import lab3.human.Item;

public class TimeSkip {
    private int currentTime = 0;
    private static String currentPhase = "Утро";
    private static int staffVar = 0;
    public void TimeToSleep(int time){
        this.currentTime += time;
    }
    public static void incPhase(){
        switch(currentPhase){
            case "Утро":
                currentPhase = "День";
                System.out.println("Наступил день.");
                break;
            case "День":
                currentPhase = "Вечер";
                System.out.println("Наступил Вечер.");
                for(Location location : Location.getLocations()){
                    if(location.getType()==LocationTypes.ROOM){
                        Location.Shelves shelves = location.new Shelves();
                    }
                }
                break;
            case "Вечер":
                currentPhase = "Ночь";
                System.out.println("Наступила ночь.");
                break;
            case "Ночь":
                currentPhase = "Утро";
                System.out.println("Наступило утро.");
                break;
        }
    }
    public static void incTime(int time){
        staffVar += time;
        if(staffVar>=360){
            incPhase();
            staffVar = 0;
        }
    }
    public void setTime(int time){
        currentTime = time;
    }
    public int getTime(){
        return currentTime;
    }
    public String getCurrentPhase(){return currentPhase;}
}