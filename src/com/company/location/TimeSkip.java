package com.company.location;

public class TimeSkip {
    private int currentTime = 0;
    public void TimeToSleep(int time){
        currentTime += time;
    }
    public void setTime(int time){
        this.currentTime = time;
    }
    public int getTime(){
        return currentTime;
    }
}