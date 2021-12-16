package GiuiAap.windowParts;

import GiuiAap.MainWindow;
import GiuiAap.windowParts.guiParts.GameControlArea;
import GiuiAap.windowParts.guiParts.GameinfoArea;
import GiuiAap.windowParts.guiParts.PlayerInfoArea;
import GiuiAap.windowParts.guiParts.PlayerControlArea;

import javax.swing.*;
import java.awt.*;

public class GuiPanel extends JPanel {

   private MainWindow mainWindow ;

    private GameControlArea gemeControlArea;
    private PlayerControlArea playerControlArea;
    private GameinfoArea gemeinfoArea;
    private PlayerInfoArea playerInfoArea;

    private  JTextArea gameLog ;
    private JScrollPane scrollLog;


   public GuiPanel(MainWindow mainWindow) {

       this.mainWindow = mainWindow;

        prepare();
        createParts();
        prepareLogArea();

        add(gemeControlArea);
        add(playerControlArea);
        add(gemeinfoArea);
        add(playerInfoArea);
        add(scrollLog);
    }

    private void prepare() {
        setBackground(Color.orange);
        setLayout(new GridLayout(5,1));
    }


    private void prepareLogArea(){
        gameLog = new JTextArea();
        gameLog.setEditable(false);
        gameLog.setLineWrap(true);
        scrollLog = new JScrollPane(gameLog);
    }


    private void createParts() {
        gemeControlArea = new GameControlArea(this);
        playerInfoArea = new PlayerInfoArea();
        playerControlArea = new PlayerControlArea(this);
        gemeinfoArea = new GameinfoArea();
    }

   public void recordLog(String msg ){
       gameLog.append(msg + "\n");
   }

    public void launchNewGame() {
       player = new Player("Boris");
       levelCount = 0;
        levelCycle();
        mainWindow.startNewGame();
       this.isMapExist = true;
       this.isGameStart = true;
    }

    public void refreshGuiInfo(GiuiAap.giuPanel.GameMap map){
        playerInfoArea.refreshPlayerInfo(map.getPlayer());
        gemeinfoArea.refreshGameInfo(map.getCountEnemies(),map.getLevelCount(),map.getMapSize());
    }

}
