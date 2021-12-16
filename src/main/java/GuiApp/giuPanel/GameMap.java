package GuiApp.giuPanel;

import GuiApp.MainWindow;
import GuiApp.models.Enemy;
import GuiApp.models.Player;
import GuiApp.models.Tools;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    private MainWindow mainWindow;

    private final int CELL_PLAYER = 1;
    private final int CELL_ENEMY = 2;
    private final int CELL_EMPTY = 0;
    private final int CELL_READY = 9;

    public static final int DIRECTION_MOVE_UP = 8;
    public static final int DIRECTION_MOVE_DOWN = 2;
    public static final int DIRECTION_MOVE_LEFT = 4;
    public static final int DIRECTION_MOVE_RIGHT = 6;


    private int[][] map;
    private int[][] invisibleMap;
    private int mapWidth;
    private int mapHeight;
    private int mapValueMin = 3;
    private int mapValueMax = 6;

    private int levelCount ;

    private int cellWidth;
    private int cellHeight;

    private Player player;
    private Enemy enemy;

     private boolean isMapExist;
    private boolean isGameStart;

    public GameMap(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.isMapExist = false;
        this.isGameStart = false;
        setBackground(Color.BLACK);
    }

  public   void launchNewGame() {
        player = new Player("Boris");
        levelCount = 1;
        levelCycle();
         mainWindow.refreshInfo(this);
         this.isMapExist = true;
         this.isGameStart = true;

    }

    private void levelCycle() {
        createMap();
        spawnPlayer();
        spawnEnemy();
        ++levelCount;
        mainWindow.recordLog("Start Level " + levelCount);
        mainWindow.refreshInfo(this);
        repaint();

    }
    private void render(Graphics g) {
        if (!isMapExist) {
            return;
        }

        if (!isGameStart) {
            return;
        }

        paintMap(g);

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {

                if (map[y][x] == CELL_EMPTY) {
                    continue;
                }

                if (map[y][x] == CELL_PLAYER) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }

                if (map[y][x] == CELL_READY) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

    private void paintMap(Graphics g) {
        int meWidth = getWidth();
        int meHeight = getHeight();

        cellWidth = meWidth / mapWidth;
        cellHeight = meHeight / mapHeight;

        g.setColor(Color.WHITE);

        for (int i = 0; i <= mapHeight; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, meWidth, y);
        }

        for (int i = 0; i <= mapWidth; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, meHeight);
        }
    }
    public void updatePlayer(int key) {
        if (!isMapExist) {
            return;
        }

        if (!isGameStart) {
            return;
        }

        int currentX = player.getX();
        int currentY = player.getY();

        switch (key) {
            case DIRECTION_MOVE_UP:
                player.moveUp();
                break;
            case DIRECTION_MOVE_LEFT:
                player.moveLeft();
                break;
            case DIRECTION_MOVE_RIGHT:
                player.moveRight();
                break;
            case DIRECTION_MOVE_DOWN:
                player.moveDown();
                break;
        }

        if (!isValidPlayerStep(currentX, currentY, player.getX(), player.getY())) {
            return;
        }
        playerNextMoveAction(currentX, currentY, player.getX(), player.getY());
        mainWindow.refreshInfo(this);
        repaint();

        if (!player.isAlive()) {
            this.isGameStart = false;
            JOptionPane.showMessageDialog(this, player.getName() + " is dead");
        }

        if (isFullMap()) {
            levelCycle();
            JOptionPane.showMessageDialog(this, player.getName() + " go to level " + levelCount);
        }
    }

    private void createMap() {
        mapHeight = Tools.randomValue(mapValueMin, mapValueMax);
        mapWidth = Tools.randomValue(mapValueMin, mapValueMax);
        map = new int[mapHeight][mapWidth];
        invisibleMap = new int[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = CELL_EMPTY;
                invisibleMap[y][x] = CELL_EMPTY;
            }
        }
        mainWindow.recordLog("Create map. Size " + mapWidth + "x" + mapHeight);
    }
        private void spawnPlayer() {
            player.setPosition(Tools.randomValue(0, mapWidth - 1), Tools.randomValue(0, mapHeight - 1));
            map[player.getY()][player.getX()] = CELL_PLAYER;
        }

        private void spawnEnemy() {
            enemy = new Enemy((mapWidth + mapHeight) / 2);

            int enemyPosX;
            int enemyPosY;

            for (int i = 0; i < enemy.getCountEnemies(); i++) {

                do {
                    enemyPosX = Tools.random.nextInt(mapWidth);
                    enemyPosY = Tools.random.nextInt(mapHeight);
                } while (!isEmpty(map, enemyPosX, enemyPosY) && !isEmpty(invisibleMap, enemyPosX, enemyPosY));

                invisibleMap[enemyPosY][enemyPosX] = CELL_ENEMY;
            }
        }

        private void playerNextMoveAction(int currentX, int currentY, int nextX, int nextY) {
            if (invisibleMap[nextY][nextX] == CELL_ENEMY) {
                mainWindow.recordLog(player.getName() + " has been attack");
                battle(nextX, nextY);
            }
            map[currentY][currentX] = CELL_READY;
            map[nextY][nextX] = CELL_PLAYER;
        }

        private void battle(int nextX, int nextY) {
            int currentEnemyHealth = enemy.getHealth();

            while (player.isAlive() && currentEnemyHealth > 0) {
                currentEnemyHealth -= player.getAttackPoint();
                if (currentEnemyHealth > 0) {
                    player.decreaseHP(enemy.getAttackPoint());
                } else {
                    enemy.killEnemy();
                    invisibleMap[nextY][nextX] = CELL_EMPTY;
                    break;
                }
            }
        }
        private boolean isValidPlayerStep(int currentX, int currentY, int nextX, int nextY) {
            if (nextX >= 0 && nextX < mapWidth && nextY >= 0 && nextY < mapHeight) {
                mainWindow.recordLog(player.getName() + " move to [" + player.getPosition() + "] success!");
                return true;
            } else {
                player.setPosition(currentX, currentY);
                mainWindow.recordLog(player.getName() + " is Invalid! Your move is fail!");
                return false;
            }
        }

        private boolean isFullMap() {
            for (int y = 0; y < mapHeight; y++) {
                for (int x = 0; x < mapWidth; x++) {
                    if (map[y][x] == CELL_EMPTY) return false;
                }
            }
            return true;
        }
        private boolean isEmpty(int[][] map, int x, int y) {
            return map[y][x] == CELL_EMPTY;
        }

    public Player getPlayer() {
        return player;
    }
    public String getMapSize() {
        return mapWidth + ":" + mapHeight;
    }

    public int getCountEnemies() {
        return enemy.getCountEnemies();
    }
    public int getLevelCount() {
        return levelCount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
    }