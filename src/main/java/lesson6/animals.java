package lesson6;

//1. Создать классы Собака и Кот с наследованием от класса Животное.
 //       2. Все животные могут бежать и плыть.
//       В качестве параметра каждому методу
//       передается длина препятствия. Результатом
//       выполнения действия будет печать в консоль.
//       (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
  //      3. У каждого животного есть ограничения на действия
//      (бег: кот 200 м., собака 500 м.; плавание: кот
//      не умеет плавать, собака 10 м.).
   //     4. * Добавить подсчет созданных котов, собак и животных.

public abstract class animals {
    static final int SWIM_FAIL = 0;
    static final int SWIM_OK = 1;
    static final int SWIM_NONE = -1;

  private String type;
    protected String name;
   private float maxRun;
    private float maxSwim;

    public static int scoreAnimals = 0;

    animals(String type, String name, float maxRun, float maxSwim) {
        this.name = name;
        this.type = type;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        ++scoreAnimals;
    }

    String getName() {
        return this.name;
    }

    String getType() {
        return this.type;
    }

    float getMaxRun() {
        return this.maxRun;
    }

    float getMaxSwim() {
        return this.maxSwim;
    }

    protected boolean run(float distance) {
        return (distance <= maxRun);
    }

    protected int swim(float distance) {
        return (distance <= maxSwim) ? SWIM_OK : SWIM_FAIL;
    }


}







