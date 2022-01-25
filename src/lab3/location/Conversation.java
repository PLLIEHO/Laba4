package lab3.location;

import lab3.human.Human;

public class Conversation {
    private Human FirstHuman;
    private Human SecHuman;
    private Location location;

    public Conversation(Human human1, Human human2, Location location) {
        if (location.getHumans().contains(human1) && location.getHumans().contains(human2)) {
            this.FirstHuman = human1;
            this.SecHuman = human2;
            this.location = location;
            System.out.println("Между " + human1.getName() + " и " + human2.getName() + " начался разговор.");
        } else {
            System.out.println("Люди находятся в разных отсеках");
        }

    }

    public Human getHuman1() {
        return FirstHuman;
    }

    public Human getHuman2() {
        return SecHuman;
    }
}