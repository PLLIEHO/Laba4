package com.company.location;

import com.company.human.Human;

public interface ChangeLocation {
    void addHumanToLocation(Human human);
    void removeHumanToLocation(Human human);
}