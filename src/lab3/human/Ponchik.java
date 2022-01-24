package lab3.human;

import java.util.ArrayList;
import java.util.List;

public class Ponchik extends CrewMember{
    private Bag bag;
    public Ponchik(String name, int age, States state) {
        super(name, age, state);
        this.bag = new Bag();
    }

    @Override
    public void smile(int isFunny){
        switch(isFunny){
            case 0:
                System.out.println(this.getName() + " недовольно морщится.");
                break;
            case 1:
                System.out.println(this.getName() + " кисло улыбается.");
                break;
        }
    }

    public void eatFromBag(int amount){
        int counter = 0;
        List<Bag.Sandwich> sandwichesToDelete = new ArrayList<>();
        bag.openBag(this);
        if(amount<=bag.getSandwiches().size()){
            for(int i = 0; i<bag.getSandwiches().size(); i++){
                eat(bag.getSandwiches().get(i));
                sandwichesToDelete.add(bag.getSandwiches().get(i));
                counter += 1;
                if(counter>amount){
                    break;
                }
            }
            for(Bag.Sandwich sandwich1 : sandwichesToDelete){
                bag.getSandwiches().remove(sandwich1);
            }
        }
        else{System.out.println("В сумке нет столько бутербродов.");}
    }

    public void eat(Bag.Sandwich sandwich){
        for(int i = 0; i<sandwich.getItemList().size(); i++){
            this.eat(sandwich.getItemList().get(i));
        }
    }

}
