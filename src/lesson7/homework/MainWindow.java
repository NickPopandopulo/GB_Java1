package lesson7.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private final int WIN_WIDTH = 600;
    private final int WIN_HEIGHT = 600;

    GameMap gameMap;

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setResizable(false);
        setSize(WIN_WIDTH, WIN_HEIGHT);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int WIN_POS_X = (dim.width - WIN_WIDTH) / 2;
        int WIN_POS_Y = (dim.height - WIN_HEIGHT) / 2;
        setLocation(WIN_POS_X, WIN_POS_Y);

        Settings settingsWindow = new Settings(this);
        gameMap = new GameMap();

        JButton btnStartGame = new JButton("Start");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        JButton btnExitGame = new JButton("Exit");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelForButtons = new JPanel();
        panelForButtons.setLayout(new GridLayout(1, 2));
        panelForButtons.add(btnStartGame);
        panelForButtons.add(btnExitGame);
        add(panelForButtons, BorderLayout.SOUTH);

        add(gameMap, BorderLayout.CENTER);
        setVisible(true);
    }

    public void startGameWithUserSettings(int gameMode, int mapSize, int winLength) {
        gameMap.startGame(gameMode,mapSize,winLength);
    }
}
