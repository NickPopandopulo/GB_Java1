package lesson7.homework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameMap extends JPanel {

    public final static int GAME_MODE_HVH = 0;
    public final static int GAME_MODE_HVA = 1;

    private final Random RANDOM = new Random();

    private final int PLAYER1 = 1;
    private final int AI = 2;
    private final int PLAYER2 = 3;
    private final int EMPTY = 0;
    private final int STATE_WIN_PLAYER1 = 1;
    private final int STATE_WIN_AI = 2;
    private final int STATE_WIN_PLAYER2 = 3;
    private final int STATE_WIN_DRAW = 0;
    private final String MSG_WIN_PLAYER1 = "PLAYER № 1 WIN !!!";
    private final String MSG_WIN_PLAYER2 = "PLAYER № 2 WIN !!!";
    private final String MSG_WIN_AI = "AI WIN !!!";
    private final String MSG_WIN_DRAW = "DRAW !!!";
    private final int MSG_POS_X_WIN_PLAYER1 = 100;
    private final int MSG_POS_X_WIN_PLAYER2 = 100;
    private final int MSG_POS_X_WIN_AI = 197;
    private final int MSG_POS_X_WIN_DRAW = 202;
    private boolean gameOver;
    private int stateGameOver;
    private int cellWidth;
    private int cellHeight;

    private int gameMode;
    private int mapSize;
    private int winLength;

    private boolean initMap;

    private int[][] map;

    private Image imgCross;
    private Image imgZero;

    private boolean turnPlayer1;
    private boolean turnPlayer2;

    GameMap() {
        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                gameProcess(e);
            }
        });
        initMap = false;
    }

    public void startGame(int gameMode, int mapSize, int winLength) {
        this.gameMode = gameMode;
        this.mapSize = mapSize;
        this.winLength = winLength;

        cellWidth = getWidth() / mapSize;
        cellHeight = getHeight() / mapSize;

        map = new int[mapSize][mapSize];

        initMap = true;
        gameOver = false;

        turnPlayer1 = true;
        turnPlayer2 = false;

        try {
            imgCross = ImageIO.read(new File("src/lesson7/homework/cross.png"));
            imgCross = imgCross.getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH);
            imgZero = ImageIO.read(new File("src/lesson7/homework/zero.png"));
            imgZero = imgZero.getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        repaint();
    }

    private void gameProcess(MouseEvent e) {
        if (!initMap) return;
        if (gameOver) return;

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isValid(cellY, cellX) || !isEmpty(cellY, cellX)) {
            return;
        }

        if (turnPlayer1) {
            // Ход игрока № 1
            map[cellY][cellX] = PLAYER1;

            if (isWin(PLAYER1)) {
                setGameOver(STATE_WIN_PLAYER1);
                return;
            }
        } else if (turnPlayer2) {
            // Ход игрока № 2
            map[cellY][cellX] = PLAYER2;

            if (isWin(PLAYER2)) {
                setGameOver(STATE_WIN_PLAYER2);
                return;
            }
        }

        if (isDraw()) {
            setGameOver(STATE_WIN_DRAW);
            return;
        }

        if (gameMode == GAME_MODE_HVH) {
            // Меняем очередность хода игроков
            turnPlayer1 = !(turnPlayer1);
            turnPlayer2 = !(turnPlayer2);
        } else if (gameMode == GAME_MODE_HVA) {
            // Ход AI
            turnAi();
            repaint();

            if (isWin(AI)) {
                setGameOver(STATE_WIN_AI);
                return;
            }

            if (isDraw()) {
                setGameOver(STATE_WIN_DRAW);
                return;
            }
        }

    }

    private void drawMap(Graphics g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < mapSize; i++) {
            int y = i * cellHeight;
            int x = i * cellWidth;
            g.drawLine(0, y, getWidth(), y);
            g.drawLine(x, 0, x, getHeight());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
        repaint();
    }

    private void render(Graphics g) {
        if (!initMap) return;

        drawMap(g);

        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (isEmpty(y, x)) continue;

                if (map[y][x] == PLAYER1) {
                    g.drawImage(imgCross, x * cellWidth, y * cellHeight, null);
                } else if (map[y][x] == AI || map[y][x] == PLAYER2) {
                    g.drawImage(imgZero, x * cellWidth, y * cellHeight, null);
                } else {
                    throw new RuntimeException("Error in render method");
                }
            }
        }

        if (gameOver) {
            showWinMessage(g);
        }

    }

    private void turnAi() {
        if (isTurnAIWin()) return;
        if (isAIBlockHuman()) return;

        int y;
        int x;

        do {
            y = RANDOM.nextInt(mapSize);
            x = RANDOM.nextInt(mapSize);
        } while (!isValid(y, x) || !isEmpty(y, x));

        map[y][x] = AI;
    }

    private boolean isValid(int y, int x) {
        return x >= 0 && x < mapSize && y >= 0 && y < mapSize;
    }

    private boolean isEmpty(int y, int x) {
        return map[y][x] == EMPTY;
    }

    private boolean isDraw() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (isEmpty(i, j)) return false;
            }
        }
        return true;
    }

    private boolean isWin(int player) {

        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                // Горизонтальная линия
                if (checkLine(y, x, 0, 1, player)) return true;
                // Вертикальная линия
                if (checkLine(y, x, 1, 0, player)) return true;
                // Главная диагональ
                if (checkLine(y, x, 1, 1, player)) return true;
                // Побочная диагональ
                if (checkLine(y, x, 1, -1, player)) return true;
            }
        }

        return false;
    }

    private boolean checkLine(int y, int x, int dirY, int dirX, int player) {
        int lastY = y + (winLength - 1) * dirY;
        int lastX = x + (winLength - 1) * dirX;
        // Если данная линия выходит за поле, то выходим
        if (!isValid(lastY, lastX)) return false;

        // Если хотя бы один символ в линии не тот, то выходим
        for (int i = 0; i < winLength; i++) {
            if (map[y + i * dirY][x + i * dirX] != player) return false;
        }

        return true;
    }

    private void setGameOver(int gameOverState) {
        gameOver = true;
        this.stateGameOver = gameOverState;
        repaint();
    }

    private void showWinMessage(Graphics g) {
        g.setColor(new Color(0xC94E4E4E, true));
        g.fillRect(0, 225, getWidth(), 60);
        g.setColor(new Color(0xBCFFFF00, true));
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));

        switch (stateGameOver) {
            case STATE_WIN_PLAYER1:
                g.drawString(MSG_WIN_PLAYER1, MSG_POS_X_WIN_PLAYER1, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, MSG_POS_X_WIN_AI, getHeight() / 2);
                break;
            case STATE_WIN_DRAW:
                g.drawString(MSG_WIN_DRAW, MSG_POS_X_WIN_DRAW, getHeight() / 2);
                break;
            case STATE_WIN_PLAYER2:
                g.drawString(MSG_WIN_PLAYER2, MSG_POS_X_WIN_PLAYER2, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Error in showWinMessage: something wrong with stateGameOver");
        }
    }

    private boolean isTurnAIWin() {
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (!isEmpty(y, x)) continue;

                // Выигрышный ход AI
                map[y][x] = AI;
                if (isWin(AI)) {
                    return true;
                }

                // Восстанавливаем, как было
                map[y][x] = EMPTY;
            }
        }
        return false;
    }

    private boolean isAIBlockHuman() {
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (!isEmpty(y, x)) continue;

                // Блок выигрышного хода игрока
                map[y][x] = PLAYER1;
                if (isWin(PLAYER1)) {
                    map[y][x] = AI;
                    return true;
                }

                // Восстанавливаем, как было
                map[y][x] = EMPTY;
            }
        }
        return false;
    }

}
