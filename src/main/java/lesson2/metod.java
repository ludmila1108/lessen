package lessen2;

public class metod {

    public static void main(String[] args) {
        System.out.println("результат " +printNumber(30,15));
        integer(5);
        System.out.println("какое число ?"+doFive(-6));
        printLines("практика",3);
      int whatYear = 1998;
        System.out.println( "год"+ whatYear +" = "+ leapYear(whatYear));

    }


    //задание 1
    public static boolean printNumber(int a, int b) {
        return 10 <= a + b && a + b <= 20;

    }

    //задание2
    public static void integer(int a) {
        if (a >= 0)
            System.out.println("Число " + a + " положительное");
        else
            System.out.println("Число " + a + " отрицательное");
    }
    // задание 3

    public static boolean doFive(int a) {
        return a < 0;
    }

    // Задание 4
    private static void printLines(String value,int j) {
        for (int i = 0; i < j; i++)

            System.out.println("%" +i + ":" + value);
    }

        //Задание 5
           public static boolean leapYear(int year){
       return (year % 4 == 0) && (year % 100 != 0) || (year %400==0);
           }
}



