package GuiApp;

import GiuiAap.windowParts.GuiPanel;
import GiuiApp.models.Player;
import GiuiApp.windowParts.GameMap;
import GiuiApp.windowParts.GuiPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {


    private int windowWidth = 1024;
    private int windowHeight = 768;
    private int windowPosX = 300;
    private int windowPosY = 100;
    private String windowTitle = "Title";

    private GuiPanel guiPanel;
    private GiuiAap.guiPanel.GameMap gameMap;

    MainWindow() {
        setupWindow();

        guiPanel = new GuiPanel(this);
        gameMap = new GameMap(this);

        add(gameMap);
        add(guiPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setLocation(windowPosX, windowPosY);
        setTitle(windowTitle);
        setResizable(true);
    }

   public void startNewGame() {
       gameMap.launchNewGame();
    }

    public void recordLog(String msg) {
        guiPanel.recordLog(msg);
    }

    public void refreshInfo(GiuiAap.giuPanel.GameMap map){
       guiPanel.refreshGuiInfo(map);
    }
}
