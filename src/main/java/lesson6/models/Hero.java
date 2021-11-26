package lesson6.models;

public abstract class Hero {

    protected String name;
    protected float hp;
    protected float speed;
    protected int level;

    public Hero(String name, float hp, float speed) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.level = 1;
//        System.out.println("This is MAIN PARENT");
    }

    public Hero(String name) {
        this.name = name;
//        System.out.println("This is SECOND PARENT");
    }

    public void speak() {
        System.out.println(name + " says Hello");
    }

    public void run() {
        System.out.println(name + " run with speed " + speed);
//        System.out.println("this is run from Hero");
    }

    public void getMeLevel() {
        System.out.println(name + "=" + level);
    }

//    public abstract void jump();
}
