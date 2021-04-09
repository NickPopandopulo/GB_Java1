package lesson7.homework;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {

    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 250;

    private MainWindow mainWindow;

    private JRadioButton gameWithHuman;
    private JRadioButton gameWithAI;

    private JSlider sliderMapSize;
    private JSlider sliderWinLength;
    private JLabel labelMapSize;
    private JLabel labelWinLength;
    private final String TEXT_MAP_SIZE = " Map size is ";
    private final String TEXT_WIN_LENGTH = " Win length is ";
    private final int MIN_MAP_SIZE = 3;
    private final int MAX_MAP_SIZE = 10;
    private final int MIN_WIN_LENGTH = 3;

    private JButton btnConfirmSettings;

    Settings(MainWindow mainWindow) {
        setResizable(false);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        this.mainWindow = mainWindow;
        Rectangle boundsMainWindow = mainWindow.getBounds();
        int xPosWindow = (int) boundsMainWindow.getCenterX() - WINDOW_WIDTH / 2;
        int yPosWindow = (int) boundsMainWindow.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(xPosWindow, yPosWindow);

        setLayout(new GridLayout(8, 1));

        gameModeSetup();
        mapSettingsSetup();
        confirmSettings();
    }

    public void gameModeSetup() {
        gameWithHuman = new JRadioButton("Game with human");
        gameWithAI = new JRadioButton("Game with AI");

        gameWithHuman.setSelected(true);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(gameWithHuman);
        btnGroup.add(gameWithAI);

        add(new JLabel(" Choose game mode:"));
        add(gameWithHuman);
        add(gameWithAI);
    }

    public void mapSettingsSetup() {
        labelMapSize = new JLabel(TEXT_MAP_SIZE + MIN_MAP_SIZE);
        sliderMapSize = new JSlider(MIN_MAP_SIZE, MAX_MAP_SIZE, MIN_MAP_SIZE);
        sliderMapSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderMapSize.getValue();
                labelMapSize.setText(TEXT_MAP_SIZE + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });

        labelWinLength = new JLabel(TEXT_WIN_LENGTH + MIN_WIN_LENGTH);
        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MAX_MAP_SIZE, MIN_MAP_SIZE);
        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(TEXT_WIN_LENGTH + sliderWinLength.getValue());
            }
        });

        add(labelMapSize);
        add(sliderMapSize);
        add(labelWinLength);
        add(sliderWinLength);
    }

    public void confirmSettings() {
        btnConfirmSettings = new JButton("Confirm settings");
        btnConfirmSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectSettings();
                setVisible(false);
            }
        });

        add(btnConfirmSettings);
    }

    public void collectSettings() {
        int gameMode;

        if (gameWithHuman.isSelected()) {
            gameMode = GameMap.GAME_MODE_HVH;
        } else {
            gameMode = GameMap.GAME_MODE_HVA;
        }

        int mapSize = sliderMapSize.getValue();
        int winLength = sliderWinLength.getValue();

        mainWindow.startGameWithUserSettings(gameMode,mapSize,winLength);
    }

}
