package lab3.human;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private boolean isOpen = false;
    public Bag(){
        Sandwich sandwich1 = new Sandwich();
        Sandwich sandwich2 = new Sandwich();
        Sandwich sandwich3 = new Sandwich();
        sandwiches.add(sandwich1); sandwiches.add(sandwich2); sandwiches.add(sandwich3);
    }
    class Sandwich{
        private List<Item> itemList = new ArrayList<>();
        private Sandwich(){
            itemList.add(Item.CHEESE); itemList.add(Item.SAUSAGE2); itemList.add(Item.BREAD);
        }
        public List<Item> getItemList(){return itemList;}
    }

    public void openBag(Human human){
        this.isOpen = !this.isOpen;
        System.out.println("Сумка открыта человеком " + human.getName());
    }

    public List<Sandwich> getSandwiches(){
        return sandwiches;
    }
    public void setSandwiches(List<Sandwich> sandwiches){
        this.sandwiches = sandwiches;
    }
}
