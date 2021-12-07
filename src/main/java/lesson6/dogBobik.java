package lesson6;

public class dogBobik extends animals {

    private static String typeThisClass ="собака" ;
    public static int countdog = 0;

    public dogBobik(String name, float maxRun, float maxSwim) {
        super(typeThisClass,name, maxRun, maxSwim);
        ++countdog;
    }



    }
