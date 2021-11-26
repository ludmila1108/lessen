package lesson6;

public final class Mage extends Hero {

    private float mp;
    private int magicPower;
    private int costFireball = 30;

    public Mage(String name, float hp, float mp, float speed, int magicPower) {
        super(name, hp, speed);
        this.mp = mp;
        this.magicPower = magicPower;
//        System.out.println("This is name " + name);
//        System.out.println("This is Child Mage");
    }

    public void castFireball() {
        if (mp >= costFireball) {
            mp -= costFireball;
            System.out.println(name + " cast fireball");
        } else {
            System.out.println("Not enought mana. Now mp = " + mp);
        }
    }

    public void getDamage(int inputDamage) {
        hp -= inputDamage;
        System.out.println(name + " get damage " + inputDamage + ". My HP = " + hp);
    }

//    @Override
//    public void jump() {
//        System.out.println("Not Jump!");
//    }
}