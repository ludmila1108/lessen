package lesson6;

public class catFluffy extends animals {

    public static String typeThisClass = "кот";
    public static int countdog = 0;

    public catFluffy(String name, float maxRun, float maxSwim) {
        super(typeThisClass, name, maxRun, maxSwim);
        ++countdog;
    }

    @Override
    protected int swim(float distance){
        return animals.SWIM_NONE;
    }
}