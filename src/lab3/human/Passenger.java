package lab3.human;

import lab3.location.Location;
import lab3.location.TimeSkip;

import java.util.Random;

public class Passenger extends Human{
    private boolean storyTeller = false;
    public Passenger(String name, int age, States state) {
        super(name, age, state);
    }


    public void tellTheStory(Location location) {
        if (location.getHumans().contains(this)) {
            System.out.println(this + " рассказывает шутку всем обитателям локации " + location.getType() + ": ");
            this.storyTeller = true;
            class Story {
                final int beginning = new Random().nextInt(StorysBible.getBeginList().size());
                final int ending = new Random().nextInt(StorysBible.getEndList().size());

                private String createStory() {
                    String result = "";
                    result += StorysBible.getBeginList().get(beginning);
                    result += StorysBible.getEndList().get(ending);
                    return result;
                }
            }
            Story story = new Story();
            System.out.println(story.createStory());
        }
    }

    @Override
    public void smile(int isFunny){
        if(!storyTeller) {
            int answerID = new Random().nextInt(4);
            if (isFunny == 0) {
                switch (answerID) {
                    case 0:
                        System.out.println(this.getName() + ": Блин, так не смешно же!");
                        break;
                    case 1:
                        System.out.println(this.getName() + ": Не, ну такого бреда я еще не слышал.");
                        break;
                    case 2:
                        System.out.println(this.getName() + ": Внатуре, не смешно!");
                        break;
                    case 3:
                        System.out.println(this.getName() + ": ...");
                        break;
                }
            } else {
                switch (answerID) {
                    case 0:
                        System.out.println(this.getName() + ": АХАХАХАХ, НУ ТЫ ВЫДАЛ!!!");
                        break;
                    case 1:
                        System.out.println(this.getName() + ": Смешно, смешно.");
                        break;
                    case 2:
                        System.out.println(this.getName() + ": *Апплодирует*");
                        break;
                    case 3:
                        System.out.println(this.getName() + ": Кек)");
                        break;
                }
            }
        }
        else{
            System.out.println(this.getName() + ": Ну как, смешно?");
            storyTeller = false;
        }
    }

    @Override
    public void sleep(Location location, int time) {
        boolean badFlag = false;
        if ((this.getState() == States.FED || this.getState() == States.NOTHUNGRY) && location.getHumans().contains(this) && location.getZerogravs().contains(location)) {
            for(int i = 0; i<4; i++){
                Location.Shelves.Bed bed = location.getBeds().get(i);
                if(bed.getFree()){
                    bed.setFree(false);
                    System.out.println(this + " засыпает.");
                    badFlag = true;
                    this.setState(States.SLEEPY);
                    break;
                    }
                }
            }
         else if ((this.getState() == States.FED || this.getState() == States.NOTHUNGRY) && location.getHumans().contains(this)) {
            System.out.println(this + " не может уснуть - гравитация не позволяет.");
        } else if (location.getHumans().contains(this) && location.getZerogravs().contains(location)) {
            System.out.println(this + " не может уснуть - для начала надо плотно покушать.");
        }
        if(!badFlag){
            System.out.println(this + " не может уснуть - не хватает свободных кроватей.");
        }
    }
    public void setStoryTeller(boolean var){
        this.storyTeller = var;
    }
    public boolean getStoryTeller(){
        return this.storyTeller;
    }
}
