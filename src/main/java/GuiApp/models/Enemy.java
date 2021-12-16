package GiuiAap.models;

public class Enemy {

    private int health;
    private int attackPoint;
    private int x;
    private int y;

    private int enemeValueMin = 20;
    private int enemeValueMax = 20;

    private int countEnemies;

    public Enemy(int countEnemies){
        this.attackPoint = Tools.randomValue(enemeValueMin,enemeValueMax);
        this.health = Tools.randomValue(enemeValueMin,enemeValueMax);
        this.countEnemies = countEnemies;

    }

    public void setPosition(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void decreaseHP(int value){
        this.health -= value;
    }

    public int getCountEnemies() {
        return countEnemies;
    }

    public void killEnemy(){
        --countEnemies;
    }

   public int getHealth(){
        return health;
    }

    public int getAttackPoint(){
        return attackPoint;
    }
}
