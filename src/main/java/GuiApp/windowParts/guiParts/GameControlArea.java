package GiuiAap.windowParts.guiParts;

import GiuiAap.windowParts.GuiPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControlArea extends JPanel {
private GuiPanel guiPanel;
    private JButton btnStartGame;
    private JButton btnEndGame;

    public GameControlArea(GuiPanel guiPanel){
        this.guiPanel = guiPanel;
       setLayout(new GridLayout(3,1));

        btnStartGame = new JButton("Launcher Game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               guiPanel.launchNewGame();
            }
        });
        btnEndGame = new JButton("End Game");
        btnEndGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(new JLabel(" =Game Control = ",SwingConstants.CENTER) );
        add(btnStartGame);
        add(btnEndGame);
    }
}
