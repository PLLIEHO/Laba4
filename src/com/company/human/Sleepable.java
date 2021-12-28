package com.company.human;

import com.company.location.Location;

public interface Sleepable {
    void sleep(Location location, int time);
    void wakeUp();
}