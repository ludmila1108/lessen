package lesson6;

public class animalsCatDog {
    public static void main(String[] args) {
String tempWintEvent = " получилось ";
String tempLossEvent = " не получилось ";
String eventName;
String eventResult;

        dogBobik dogBobik1 = new dogBobik("Bobik", 5, 10);
       catFluffy catFluffy1 = new catFluffy("Fluffy", 10, 6);
       dogBobik dogBobik2 = new dogBobik("Barbos", 7, 20);
      catFluffy catFluffy2 = new catFluffy("Mackey", 17, 7);
 animals [] Animals = {dogBobik1,catFluffy1,dogBobik2,catFluffy2 };

 float runLength = 198;
 float swimLength = 5;

 for (int i = 0 ; i < Animals.length; i++){
     String nameString = Animals[i].getType() + "" + Animals[i].getName()+ "может";

     eventName = " пробежал на " + Animals[i].getMaxRun() + " m .дистанция  ";
     eventResult = Animals[i].run(runLength) ? tempWintEvent : tempLossEvent;
     result(nameString,eventName,runLength,eventResult);


  int swimResult = Animals[i].swim(swimLength);
  eventName = "проплыть на " + Animals[i].getMaxSwim() + "  m.";
 eventResult = (swimResult == animals.SWIM_NONE) ? tempWintEvent : tempLossEvent;

if (swimResult ==animals.SWIM_FAIL)
    eventResult = " не умеет плавать";
     result(nameString,eventName,swimLength,eventResult);
 }
        System.out.println(animals.scoreAnimals + "cat = " + catFluffy.scoreAnimals + "dog = "+ dogBobik.scoreAnimals);
    }


    private static void result(String nameanimals , String event ,float eventLengts, String resultEvent)
    {
        System.out.println(nameanimals + event +  eventLengts + resultEvent );
    }
}