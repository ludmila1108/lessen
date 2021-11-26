package lesson6;

public class Director {
    public static void main(String[] args) {

//        Hero hero = new Hero("Hero", 100, 30);

        Warrior warrior = new Warrior("Warrior", 100, 15, 12.5f, 10);
        Archer archer = new Archer("Archer", 70, 16f, 10, 45.6f);
        Mage mage = new Mage("Mage", 50, 100, 13f, 60);
        Titan titan1 = new Titan("Titan1", 600, 100, 1.3f, 10);
        Titan titan2 = new Titan("Titan2", 600, 100, 1.3f, 10);

//        Hero[] army = {warrior, archer, mage, titan1, titan2};
        Hero[] army = {archer, mage};

        for (int i = 0; i < army.length; i++) {
            army[i].run();
            army[i].speak();
            if (army[i] instanceof Warrior) {
                Warrior tmp = (Warrior) army[i];
                tmp.attack(123);
            }
            if (army[i] instanceof Titan) {
                Titan tmp = (Titan) army[i];
                tmp.superAttack();
            }
        }

//        byte abc = 15;
//        int cde = abc;
//        System.out.println("cde > " + cde);

//        int a = 350;
//        byte b = (byte) a;
//        System.out.println("b > " + b);


//        titan.superAttack();
//        warrior.run();
//        archer.run();
//        mage.run();
//        titan.run();

//        warrior.attack(3);

//        titan.attack(10);
//        titan.getDamage(120);
//        titan.run();
//        titan.speak();
//        titan.doSomething();
//        titan.getMeLevel();

//        warrior.attack();
//        warrior.run();
//        warrior.speak();
//        warrior.getDamage(16);
//
//        archer.escapeFromBattle();
//        archer.getDamage(60);
//        archer.escapeFromBattle();
//
//        mage.getDamage(20);
//        mage.castFireball();
//        mage.castFireball();
//        mage.castFireball();
//        mage.castFireball();

//        warrior.getMeLevel();
//        archer.getMeLevel();
//        mage.getMeLevel();

    }

}

