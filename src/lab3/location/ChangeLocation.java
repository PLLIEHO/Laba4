package lab3.location;

import lab3.human.Human;

public interface ChangeLocation {
    void addHumanToLocation(Human human);
    void removeHumanToLocation(Human human);
}