package lab3.human;

public enum States {
    HUNGRY("Голодный"),
    FED("Сытый"),
    NOTHUNGRY("Не голодный"),
    SLEEPY("Сонный");

    private final String name;

    States(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}