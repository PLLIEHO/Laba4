package lab3.human;

import lab3.exceptions.NegativeAgeException;

import java.util.Objects;

public abstract class AbstractHuman {
    private int cap;
    private String name;
    private int age;
    private States state;
    private int weight;


    public AbstractHuman(String name, int age, States state) {
        this.name = name;
        if(age>=0){
            this.age = age;
        } else {
            throw new NegativeAgeException("Ошибка. Возраст не может быть отрицательным.");
        }
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public void happyBirthday(){
        this.age += 1;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight){
        this.weight = weight;
    }

    public void incWeight(){
        this.weight += 1;
        System.out.println(this.getName() + " толстеет на килограмм!");
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }
    public void setState(States state){
        this.state = state;
    }
    public States getState(){
        return state;
    }
    @Override
    public String toString() {
        return "Человек " + name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, state, weight);
    }

    @Override
    public boolean equals(Object o) {
        if(getClass()!=o.getClass()){return false;}
        Human that = (Human) o;
        return getName().equals(that.getName()) && getAge() == that.getAge() && getState() == that.getState();
    }
}
