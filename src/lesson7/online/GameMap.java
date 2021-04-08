package Lesson07.online;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 07.04.2021
 */

public class GameMap extends JPanel {
    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;

    GameMap() {
        setBackground(Color.BLACK);
    }

    void startGame(int modeGame, int mapSizeX, int mapSizeY, int winLength) {
        System.out.println("mode =  " + modeGame +
                "\nmapSizeX = " + mapSizeX +
                "\nmapSizeY = " + mapSizeY +
                "\nwinLength = " + winLength);
    }
}
