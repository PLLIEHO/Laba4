package lab3.human;

import java.util.Random;

public class Passenger extends Human{
    public Passenger(String name, int age, States state) {
        super(name, age, state);
    }

    public void tellTheStory(){
        class Story {
            final int beginning = new Random().nextInt(3);
            final int ending = new Random().nextInt(3) + 4;

            private String createStory(){
                String result = "";
                for (StorysBible beg : StorysBible.values()){
                    if(beg.getID() == beginning){
                        result += beg.getBody();
                    }
                    if(beg.getID() == ending){
                        result += beg.getBody();
                    }
                }
                return result;
            }
        }
        Story story = new Story();
        System.out.println(story.createStory());
    }
}
