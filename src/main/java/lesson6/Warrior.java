package lesson6;

public class Warrior extends Hero {

    protected int defence;
    protected int power;
    protected int attackPoint;

    public Warrior(String name, float hp, int defence, float speed, int power) {
        super(name, hp, speed);
        this.defence = defence;
        this.power = power;
        this.attackPoint = power * 2;
//        System.out.println("This is Child Warrior");
    }

    public void attack(int value) {
        System.out.println(name + " attack with point " + attackPoint * value);
    }

    public void getDamage(int inputDamage) {
        hp -= inputDamage / defence;
        System.out.println(name + " get damage " + inputDamage + ". My HP = " + hp);
    }

//    @Override
//    public void jump() {
//        System.out.println("Jump!");
//    }

//    @Override
//    public void run() {
//        System.out.println("this is run from Warrior");
//    }

}
