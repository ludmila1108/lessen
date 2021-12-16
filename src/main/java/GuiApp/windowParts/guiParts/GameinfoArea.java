
package GiuiAap.windowParts.guiParts;

import javax.swing.*;
import java.awt.*;

    public class GameinfoArea extends JPanel {

        private  String prefixemenyCount ="Emenies";
        private  String prefixlevel ="level:";
        private  String prefixsizeMap ="SizeMap";

        private  JLabel  emenyCount;
        private JLabel levelGame;
        private JLabel sizeMap;

        public GameinfoArea() {
            setLayout(new GridLayout(4,1));

            emenyCount = new JLabel(prefixemenyCount + "-");
            levelGame = new JLabel( prefixlevel + "-");
            sizeMap = new JLabel( prefixsizeMap + "- :-");

            add(new JLabel("=Game info = ",SwingConstants.CENTER) );
            add(emenyCount);
            add(levelGame);
            add(sizeMap);


        }
        public void refreshGameInfo(int  counInfo,int level,String sizeMapInfo){
         emenyCount.setText(prefixemenyCount + counInfo );
           levelGame.setText(prefixlevel + level);
           sizeMap.setText(prefixsizeMap + sizeMapInfo);
        }
    }





