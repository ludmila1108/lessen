package lesson6;

public class Archer extends Hero {

    private int power;
    private int attackPoint;
    private float agility;

    public Archer(String name, int hp, float speed, int power, float agility) {
        super(name, hp, speed);
        this.power = power;
        this.attackPoint = power * 3;
        this.agility = agility;
//        System.out.println("This is Child Archer");

    }

    public void attack() {
        System.out.println(name + " attack with point " + attackPoint);
    }

    public void getDamage(int inputDamage) {
        hp -= inputDamage;
        System.out.println(name + " get damage " + inputDamage + ". My HP = " + hp);
    }

    public void escapeFromBattle() {
        if (hp < 20) {
            System.out.println(name + " escape from battle");
        }
    }

//    @Override
//    public void jump() {
//        System.out.println("Jump!");
//    }
}
