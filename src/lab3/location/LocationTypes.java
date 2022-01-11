package lab3.location;

public enum LocationTypes {
    LADDER("Лестница"),
    FOODFACILITY("Пищевой отсек"),
    BRIDGE("Мостик");

    private final String name;

    LocationTypes(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}