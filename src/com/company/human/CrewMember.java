package com.company.human;

import com.company.location.Location;

public class CrewMember extends Human{
    private Stomach stomach;
    public CrewMember(String name, int age, States state) {
        super(name, age, state);
        stomach = new Stomach();
    }

    public void randomEat() {
        int capac;
        capac = capacity(this);
        Revision revision = new Revision();
        if (this.getState() != States.SLEEPY) {
            Item item = revision.revisionStep(this.getCap(), stomach, this);
            if (capac == 0) {
                System.out.println(this + " ест " + item);
            } else if (capac == 1) {
                System.out.println(this + " не может съесть " + item + ". Причина: объелся.");
            }
        } else {
            System.out.println(getName() + " сейчас спит. Никакой еды.");
        }
    }

    public void declare(Location location) {
        if (location.getHumans().contains(this) && this.getState()!=States.SLEEPY) {
            System.out.println(getName() + " заявляет, что необходимо провести ревизию продуктов на " + location);
        }
        else if(location.getHumans().contains(this)){
            System.out.println(getName() + " сейчас спит. Никаких ревизий.");
        }
        else{
            System.out.println(getName() + " не находится на необходимой локации " + location);
        }
    }
}