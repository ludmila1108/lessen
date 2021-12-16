package GiuiAap.models;

public class Player {

    private String name;
    private int health;
    private int attackPoint;
    private int x;
    private int y;

    public Player(String name){
        this.name = name;
        this.health = 100;
        this.attackPoint = 15;

    }

    public void setPosition(int x,int y){
        this.x = x;
        this.y = y;

    }

    public void moveUp(){
        this.y -= 1;
    }
    public void moveDown(){
        this.y += 1;
    }
    public void moveLeft(){
        this.y -= 1;
    }
    public void moveRight(){
        this.y += 1;
    }

    public String getPosition(){
        return (x + 1) + ":" + (y +1);
    }
    public void decreaseHP(int value){
        this.health -= value;
    }
public boolean isAlive(){
        return health > 0;
}

public String getName(){
        return name;
}
public int getHealth(){
        return health;
}
public int getAttackPoint(){
        return attackPoint;
}
public int getX(){
        return x;
}
public int getY(){
        return y;
}
}
