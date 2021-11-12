package lesson5;
//1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//2. Конструктор класса должен заполнять эти поля при создании объекта.
//3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
//4. Создать массив из 5 сотрудников.
//Пример:
//Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.

public class manedger {
    public static void main(String[] args) {
        Player [] employeeArray = new Player [5];
        employeeArray[0] = new Player("иванов иван иванович","менеджер",35,88888888,90,"rty@mail.ru");
        employeeArray[1] = new Player("степанов степан степанович","разработчик",45,77777,75,"-");
        employeeArray[2] = new Player("к","инжинер",36,55,69,"-");
        employeeArray[3] = new Player("петров петр петрович","инспектор",32,77,23,"");
        employeeArray[4] = new Player("л","директор",56,66,555,"-");

        for (int i=0; i <employeeArray.length; i++)
            if (employeeArray[i].age > 40) employeeArray[i].print();
    }
}