package lesson6;

public class Titan extends Warrior {

    private String color;

    public Titan(String name, float hp, int defence, float speed, int power) {
        super(name, hp, defence, speed, power);
        this.color = "Black";
    }

    public Titan(String name, float hp, int defence, float speed, int power, String color) {
        super(name, hp, defence, speed, power);
        this.color = color;
    }

    @Override
    public void attack(int value1) {
        System.out.println(name + " attack with point " + power);
    }

    @Override
    public void speak() {
        super.speak();
        super.run();
        System.out.println("Agggrrr!");
    }

    public void superAttack() {
        System.out.println(name + " superAttack!!!!");
    }

    public void doSomething(int value) {
        System.out.println();
    }

}
