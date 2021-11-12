package lesson5;

public class Player {
    String fullName;
    String position;
    int age;
    int tel;
    int salary;
    String email;


    public Player(String fullName, String position,int age, int tel, int salary, String email) {
        this.fullName = fullName ;
        this.  position = position;
        this. age = age;
        this.tel=tel;
        this. salary=salary;
        this.email=email;
    }
    public String toString(){
        return String.format("Имя: %s \nДолжность: %s \nEmail: %s \n Номер телефона: %s \n Зарплата: %d \n Возраст: %d \n",
                fullName, position,age, email, tel, salary);
    }
    public void print(){
        System.out.println(this);
    }
}
