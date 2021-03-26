package lesson3.homework;

/*
 * Полностью разобраться с кодом, попробовать переписать с нуля;
 * ^ Усовершенствовать метод проверки победы (через циклы);
 * ^ Расширить поле до 5х5 и в качестве условий победы установить серию равной 4.
 * ^^ Проработать базовый искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */

import java.util.Random;
import java.util.Scanner;

public class Homework3 {

    public static char[][] map;
    public static int sizeMapX;
    public static int sizeMapY;

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static char human = 'X';
    public static char ai = 'O';
    public static char empty = '_';

    public static int win = 4;

    public static void main(String[] args) {
        createMap(5, 5);
        printMap();

        while (true) {
            turnHuman();
            printMap();
            if (isWin(human)) {
                System.out.println("Человек побеждает!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

            turnAi();
            printMap();
            if (isWin(ai)) {
                System.out.println("ИИ побеждает!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

        }
    }

    public static void createMap(int sizeX, int sizeY) {
        sizeMapX = sizeX;
        sizeMapY = sizeY;
        map = new char[sizeMapY][sizeMapX];

        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                map[y][x] = empty;
            }
        }
    }

    public static void printMap() {
        System.out.println(" —————————————————————");
        for (int i = 0; i < sizeMapY; i++) {
            for (int j = 0; j < sizeMapX; j++) {
                System.out.print(" | " + map[i][j]);
            }
            System.out.println(" | ");
        }
        System.out.println(" —————————————————————");
    }

    public static void turnHuman() {
        int x;
        int y;

        do {
            System.out.print("Введите позицию X: ");
            x = scanner.nextInt() - 1;
            System.out.print("Введите позицию Y: ");
            y = scanner.nextInt() - 1;
        } while (!(isValid(x, y) && isEmpty(x, y)));

        map[y][x] = human;
    }

    public static void turnAi() {
        int x;
        int y;

        do {
            // Рандомный поиск клетки, где есть человек
            do {
                x = random.nextInt(sizeMapX);
                y = random.nextInt(sizeMapY);
            } while (map[y][x] != human);

            // Рандомный поиск ближайшей к человеку свободной клетки для ИИ
            x += random.nextInt(3) - 1;
            y += random.nextInt(3) - 1;
        } while (!isValid(x, y) || !isEmpty(x, y));

        map[y][x] = ai;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < sizeMapX && y >= 0 && y < sizeMapY;
    }

    public static boolean isEmpty(int x, int y) {
        return map[y][x] == empty;
    }

    public static boolean isDraw() {
        for (int i = 0; i < sizeMapY; i++) {
            for (int j = 0; j < sizeMapX; j++) {
                if (isEmpty(i, j)) return false;
            }
        }
        return true;
    }

    public static boolean isWin(char player) {
        int[] count;

        // --- Диагонали ---

        // Ниже главной (и побочной) диагонали
        count = countDiagonals(1, 0, player);
        if (count[0] == win || count[1] == win) return true;

        // Главная (и побочная) диагональ
        count = countDiagonals(0, 0, player);
        if (count[0] == win || count[1] == win) return true;

        // Выше главной (и побочной) диагонали
        count = countDiagonals(0, 1, player);
        if (count[0] == win || count[1] == win) return true;

        // --- Диагонали ---

        // Вертикальные и горизонатльные линии
        for (int i = 0; i < sizeMapY; i++) {
            count[0] = 0; // вертикальная
            count[1] = 0; // горизонтальная
            for (int j = 0; j < sizeMapX; j++) {

                count[0] = (map[i][j] == player) ? ++count[0] : 0;
                count[1] = (map[j][i] == player) ? ++count[1] : 0;

                if (count[0] == win || count[1] == win) return true;
            }
        }

        return false;
    }

    public static int[] countDiagonals(int i, int j, char player) {
        int[] count = new int[2];
        int x;
        int y;

        for (int k = 0; k < sizeMapX; k++) {
            y = k + i;
            x = k + j;

            if (!isValid(x, y)) continue;

            count[0] = (map[y][x] == player) ? ++count[0] : 0; // главная дианональ (или возле нее)
            count[1] = (map[y][sizeMapX - x - 1] == player) ? ++count[1] : 0; // побочная

            // Если где-то набралось win символов подряд, выходим
            if (count[0] == win || count[1] == win) return count;
        }
        return count;
    }

}
