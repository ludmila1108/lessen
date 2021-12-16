package GiuiAap.windowParts.guiParts;

import GiuiAap.windowParts.GuiPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerControlArea extends JPanel {

    private GuiPanel guiPanel;

    private JButton btnMoveUp;
    private JButton btnMoveLeft;
    private JButton btnMoveRight;
    private JButton btnMoveDown;

    public PlayerControlArea(GuiPanel guiPanel){
        this.guiPanel = guiPanel;

        setLayout(new GridLayout(2,3));

        btnMoveUp = new JButton("⮝");//U+2B9D
        btnMoveUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiPanel.recordLog(" btnMoveUp");
            }
            });
        btnMoveLeft = new JButton("⮜");//U+2B9C
        btnMoveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiPanel.recordLog("  btnMoveLeft");
            }
        });

        btnMoveRight = new JButton("➤");//  U+2B9E
        btnMoveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiPanel.recordLog(" btnMoveRight");
            }
        });

        btnMoveDown = new JButton("⮟");//U+2B9F
        btnMoveDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiPanel.recordLog("  btnMoveDown");
            }
        });

        add(new JPanel());
       add(btnMoveUp);
        add(new JPanel());
        add(btnMoveLeft);
        add(btnMoveDown);
        add(btnMoveRight);
    }
}
