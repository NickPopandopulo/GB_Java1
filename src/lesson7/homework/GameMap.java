package lesson7.homework;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMap extends JPanel {

    public final static int GAME_MODE_HVH = 0;
    public final static int GAME_MODE_HVA = 1;

    GameMap() {
        setBackground(new Color(0xFF00D4C1));
    }

    public void startGame(int gameMode, int mapSize, int winLength) {
        drawGrid(mapSize);
    }

    public void drawGrid(int mapSize) {
        setLayout(new GridLayout(mapSize,mapSize,-1,-1));
        Border border = BorderFactory.createLineBorder(getBackground());
        setBorder(border);

        border = BorderFactory.createLineBorder(new Color(0xFF3500));
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                JLabel lbl = new JLabel();
                lbl.setBorder(border);
//                lbl.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        super.mouseClicked(e);
//                        lbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
//                        lbl.setText("Clicked");
//                    }
//                });
                add(lbl);
            }
        }
    }

}
