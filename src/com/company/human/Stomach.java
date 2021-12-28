package com.company.human;

import java.util.ArrayList;
import java.util.List;

public class Stomach {
    private List<Item> itemList;
    private int consumedEnergy;
    private int weightStep = 30;
    private int kg = weightStep;
    public Stomach(){
        itemList = new ArrayList<>();
    }

    private void setKg(int kg){
        this.kg = kg;
    }

    public void setWeightStep(int weightStep){
        this.weightStep = weightStep;
    }

    protected boolean consume(Item item){
        itemList.add(item);
        consumedEnergy += item.getKKal();
        if(consumedEnergy >= kg){
            setKg(kg+weightStep);
            return true;
        }
        else{
            return false;
        }
    }
    protected Item removeLast(){
        Item item = itemList.get(itemList.size()-1);
        itemList.remove(itemList.size()-1);
        return item;
    }
    public List<Item> getStomach(){
        return itemList;
    }
}
