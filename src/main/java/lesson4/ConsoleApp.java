package lesson4;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 30.10.2021
 */

public class ConsoleApp {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    //---Description Player
    public static char player = 'P';// обоозначения героя
    public static String namePlayer = "King Artur"; // имя
    public static int healthPlayer = 100;// здоровье
    public static int strPlayer = 10; // сила
    public static int xPosPlayer;// позиция героя
    public static int yPosPlayer;
//движение лево право вверх низ ,final означает что значения не поменять
    public static final int moveUpPlayer = 8;
    public static final int moveLeftPlayer = 4;
    public static final int moveRightPlayer = 6;
    public static final int moveDownPlayer = 2;

    //---Description Location комната
    public static char[][] location;
    public static char[][] invisibleLocation;
    public static int locWidth;
    public static int locHeight;
    public static int locMin = 3; // минимум комнат
    public static int locMax = 6;//максимум комнат
    public static char emptyRoom = '_'; // комната пуста
    public static char readyRoom = '+'; //комната где уже был игрок
    public static boolean isRandomStartPointPlayer = false;//

    //---Description Enemy // враг
    public static char enemy = 'E';
    public static int healthEnemy;
    public static int strEnemy;
    public static int enemyValueMin = 20;// показатели
    public static int enemyValueMax = 40;
    public static int countEnemies; // количество врагов

    public static void main(String[] args) {

        createLocation();
        createPlayer(isRandomStartPointPlayer);
        createEnemy();
        printLocation();

        while (true) {
            directionPlayer();
            printLocation();

            if (!isALivePlayer()) {
                System.out.println(namePlayer + " is dead!");
                break;
            }

            if (isReadyLocation()) {
                System.out.println(namePlayer + " win!");
                break;
            }
        }

        System.out.println("GoodBye! Game over!");

    }

    public static void createLocation() { // создание карты
        locWidth = myRandomValueInt(locMin, locMax);// случайные размеры в заданых пределах
        locHeight = myRandomValueInt(locMin, locMax);
        location = new char[locHeight][locWidth];

        for (int y = 0; y < locHeight; y++) {// заполнение комнаты пустатой
            for (int x = 0; x < locWidth; x++) {
                location[y][x] = emptyRoom;
            }
        }
        System.out.println("New location created. Size " + locWidth + "x" + locHeight);// вывод карты
    }// описание какого будет рандонная локация

    public static void createPlayer(boolean isRandom) {// ставим на локацию героя
        if (isRandom) {
            xPosPlayer = myRandomValueInt(0, locWidth - 1);// стартовая позиция игрока
            yPosPlayer = myRandomValueInt(0, locHeight - 1);
        } else {
            xPosPlayer = 0;
            yPosPlayer = 0;
        }
        location[yPosPlayer][xPosPlayer] = player;
        System.out.println(namePlayer + " has spawn in room [" + xPosPlayer + ":" + yPosPlayer + "]");
// наш игрок начал игру в комнате
    }

    public static void createEnemy() {// раставление врагов
        countEnemies = (locWidth + locHeight) / 2;// количество врагов относительно размера карты
        healthEnemy = myRandomValueInt(enemyValueMin, enemyValueMax);//случайное здоровье
        strEnemy = myRandomValueInt(enemyValueMin, enemyValueMax);//случайное количество силы
        // растановка врагов
        int xPosEnemy;
        int yPosEnemy;

        for (int i = 0; i < countEnemies; i++) {//генерирование количества врагов

            do {// сгинирируй координаты и проверить на пустоту
                xPosEnemy = random.nextInt(locWidth); //[0; locWidth)
                yPosEnemy = random.nextInt(locHeight); //[0; locHeight)
            } while (!isEmptyRoom(xPosEnemy, yPosEnemy));//если комната занята ,генериреем еще до пустоты

            location[yPosEnemy][xPosEnemy] = enemy;//координаты врага сгенеруемые циклом
        }
        System.out.println("Enemies has spawn. Count is " + countEnemies + ", HP=" + healthEnemy + ", STR=" + strEnemy);
    }//описания полученного количества врагов и их сила здоровье

    public static void directionPlayer() {// передвижение игрока

        int currentX = xPosPlayer;// текущие координаты игрока
        int currentY = yPosPlayer;//

        int playerMoveValue;//данные от игрока

        do {
            System.out.print("Enter destination: (UP=" + moveUpPlayer + " | DOWN=" + moveDownPlayer +
                    " | LEFT=" + moveLeftPlayer + " | RIGHT=" + moveRightPlayer + ") >>> ");//ведите направление
            playerMoveValue = scanner.nextInt();//ввод данные в карту

            switch (playerMoveValue) {// передвижения игрока по карте
                case moveUpPlayer:
                    yPosPlayer -= 1;
                    break;
                case moveDownPlayer:
                    yPosPlayer += 1;
                    break;
                case moveLeftPlayer:
                    xPosPlayer -= 1;
                    break;
                case moveRightPlayer:
                    xPosPlayer += 1;
                    break;
            }

        } while (!isValidMovePlayer(currentX, currentY, xPosPlayer, yPosPlayer));

        playerNextMoveAction(currentX, currentY, xPosPlayer, yPosPlayer);//будем бесконечна спрашивать игрока координаты пока не получим валидные
        //получив валидные передвигаем игрока 

    }

    public static void playerNextMoveAction(int lastX, int lastY, int nextX, int nextY) {
        if (location[nextY][nextX] == enemy) {
            healthPlayer -= strEnemy;
            countEnemies--;
            System.out.println("Warning! Enemy give damage to " + namePlayer + " is " + strEnemy + ". " + namePlayer + " health is " + healthPlayer);
            System.out.println("Count enemies is " + countEnemies);
        }

        location[lastY][lastX] = readyRoom;
        location[nextY][nextX] = player;

    }

    public static boolean isValidMovePlayer(int currentX, int  currentY, int nextX, int nextY) {//проверка на волидность движения игрока
        if (nextX >= 0 && nextX < locWidth && nextY >= 0 && nextY < locHeight) {
            System.out.println(namePlayer + " move to [" + nextX + ":" + nextY + "]");
            return true;
        } else {
            System.out.println("Invalid move! Try again!");
            xPosPlayer = currentX;
            yPosPlayer = currentY;
            return false;// ели нет то возвращаем игрока обратно
        }
    }

    public static boolean isEmptyRoom(int x, int y) {//проверка пустоты в комнате
        return location[y][x] == emptyRoom;
    }

    public static void printLocation() {// отоброжение карты в консоль
        System.out.println("=====> LOCATION <=====");
        for (int y = 0; y < locHeight; y++) {
            for (int x = 0; x < locWidth; x++) {
                System.out.print(location[y][x] + "|");// содержимое комнаты с границами
            }
            System.out.println();
        }
        System.out.println("======================");
    }

    public static int myRandomValueInt(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isALivePlayer() {
        return healthPlayer > 0;
    }

    public static boolean isReadyLocation() {
        for (int y = 0; y < locHeight; y++) {
            for (int x = 0; x < locWidth; x++) {
                if (location[y][x] == emptyRoom) {
                    return false;
                }
            }
        }
        return true;
    }

}