package lab3.human;

import lab3.location.Location;
import lab3.location.TimeSkip;

public class Human extends AbstractHuman implements Edible, Sleepable {
    private Stomach stomach;

    public Human(String name, int age, States state) {
        super(name, age, state);
        System.out.println("Создан человек: " + name + ", " + age);
        this.capper(state);
        this.stomach = new Stomach();
    }

    private void capper(States state){
        if (state.equals(States.FED)) {
            setCap(0);
        } else if (state.equals(States.HUNGRY)) {
            setCap(10);
        } else {
            setCap(1);
        }
    }

    int capacity(Human human) {
        int value = 0;
        if (human.getCap() > 0) {
            if (human.getState().equals(States.HUNGRY)) {
                human.setCap(human.getCap() - 1);
                value = 0;
            }
            if (human.getState().equals(States.NOTHUNGRY)) {
                human.setCap(human.getCap() - 1);
                value = 2;
            }
        } else {
            if (human.getState().equals(States.HUNGRY)) {
                human.setState(States.FED);
                value = 1;
            }
            if (human.getState().equals(States.NOTHUNGRY)) {
                value = 3;
            }
        }
        return value;
    }


    public void eat(Item item) {
        int capac;
        final int var0 = 0;
        final int var1 = 1;
        final int var2 = 2;
        final int var3 = 3;
        if (getState() != States.SLEEPY) {
            capac = capacity(this);
            if (capac == var0) {
                System.out.println(this + " ест " + item);
                boolean flag = stomach.consume(item);
                if (flag) {
                    this.incWeight();
                }
            } else if (capac == var2) {
                System.out.println(this + " ест " + item + ", но без особого удовольствия");
                boolean flag = stomach.consume(item);
                if (flag) {
                    this.incWeight();
                }
            } else if (capac == var3) {
                System.out.println(this + " не может съесть " + item + ". Причина: Больше не хочет.");
            } else if(capac == var1){
                System.out.println(this + " не может съесть " + item + ". Причина: объелся.");
            }
        }
    }


    public void sleep(Location location, int time) {
        final int year = 8760;
        if (this.getState() == States.FED && location.getHumans().contains(this) && location.getZerogravs().contains(location)) {
            System.out.println(this + " засыпает.");
            this.setState(States.SLEEPY);
            TimeSkip timeSkip = new TimeSkip();
            timeSkip.TimeToSleep(time);
            System.out.println("Во сне время быстро летит. " + time + " часов пролетают незаметно. Для " + this.getName() + ", разумеется.");
            if (time >= year) {
                int size = location.getHumans().size();
                for (int i = 0; i < size; i++) {
                    location.getHumans().get(i).happyBirthday();
                    System.out.println(this.getName() + " так долго спал, что " + location.getHumans().get(i).getName() + " постарел на целый год.");
                }
            }
        } else if (this.getState() == States.FED && location.getHumans().contains(this)) {
            System.out.println(this + " не может уснуть - гравитация не позволяет.");
        } else if (location.getHumans().contains(this) && location.getZerogravs().contains(location)) {
            System.out.println(this + " не может уснуть - для начала надо плотно покушать.");
        }
    }

    public void vomit() {
        if (stomach.getStomach().size() > 0) {
            this.setCap(getCap() + 1);
            Item item = stomach.removeLast();
            System.out.println(this.getName() + " стошнило предметом " + item);
        }
    }

    public void wakeUp() {
        if (this.getState() == States.SLEEPY) {
            this.setState(States.NOTHUNGRY);
            System.out.println(this.getName() + " проснулся и снова полон сил.");
        }
    }

    public String getDescription() {
        States state = this.getState();
        if (state.equals(States.HUNGRY)) {
            return this.getName() + " сейчас очень голодный и готов съесть целую кучу продуктов.";
        }
        if (state.equals(States.NOTHUNGRY)) {
            return this.getName() + " сейчас не очень голодный и съест одно блюдо, но не более.";
        }
        if (state.equals(States.FED)) {
            return this.getName() + " наелся и чувствет себя хорошо.";
        }
        if (state.equals(States.SLEEPY)) {
            return this.getName() + " сейчас крепко спит, ведь в невесомости и после плотного обеда спится очень хорошо. Тем более, " + this.getName() + " явно давно не спал, вот его и сморило.";
        } else {
            return "";
        }
    }
}
