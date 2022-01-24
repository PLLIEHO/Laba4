package lab3.location;

import lab3.human.Human;

public class Conversation {
    private Human human1;
    private Human human2;
    private Location location;

    public Conversation(Human human1, Human human2, Location location) {
        if (location.getHumans().contains(human1) && location.getHumans().contains(human2)) {
            this.human1 = human1;
            this.human2 = human2;
            this.location = location;
            System.out.println("Между " + human1.getName() + " и " + human2.getName() + " начался разговор.");
        } else {
            System.out.println("Люди находятся в разных отсеках");
        }

    }

    public Human getHuman1() {
        return human1;
    }

    public Human getHuman2() {
        return human2;
    }
}