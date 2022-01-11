package lab3.location;

public class TimeSkip {
    private int currentTime = 0;
    public void TimeToSleep(int time){
        this.currentTime += time;
    }
    public void setTime(int time){
        currentTime = time;
    }
    public int getTime(){
        return currentTime;
    }
}