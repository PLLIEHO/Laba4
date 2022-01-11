package lab3.human;

import lab3.location.Location;

public interface Sleepable {
    void sleep(Location location, int time);
    void wakeUp();
}