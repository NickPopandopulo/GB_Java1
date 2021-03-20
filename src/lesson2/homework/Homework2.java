package lesson2.homework;

/*
   1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
   Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;

   2 Задать пустой целочисленный массив размером 8.
   Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;

   3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,принимающий на вход массив и
   умножающий числа меньше 6 на 2;

   4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;

   5* Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
   заполнить его диагональные элементы единицами, используя цикл(ы);

   6** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным,
   или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
   [1,2,3,4,5], -2 => [3,4,5,1,2]
   [1,2,3,4,5], 2 => [4,5,1,2,3]

   7 *** Не пользоваться вспомогательным массивом при решении задачи 6.
*/

public class Homework2 {

    public static void main(String[] args) {

        // --- Задание № 1 ---
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задание № 1");
        System.out.print("Было:  ");
        printArray(array);
        System.out.print("Стало: ");
        printArray(inverse(array));
        System.out.println();

        // --- Задание № 2 ---
        System.out.println("Задание № 2");
        printArray(progression(new int[8]));
        System.out.println();

        // --- Задание № 3 ---
        array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задание № 3");
        System.out.print("Было:  ");
        printArray(array);
        System.out.print("Стало: ");
        printArray(changeArray(array));
        System.out.println();

        // --- Задание № 4 ---
        array = new int[]{1, -5, 3, -2, 11, -4, 5, -2, 4, -8, 9, -1};
        System.out.println("Задание № 4");
        printArray(array);
        System.out.println("Минимальное значение: " + min(array));
        System.out.println("Максимальное значение: " + max(array) + "\n");

        // --- Задание № 5 ---
        System.out.println("Задание № 5");
        int n = 5;
        int[][] arraySquare = diagonalsEqualOne(new int[n][n]);
        for (int i = 0; i < arraySquare.length; i++) {
            printArray(arraySquare[i]);
        }
        System.out.println();

        // --- Задание № 6, 7 ---
        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Задание № 6, 7");
        printArray(array);

        n = 2;
        System.out.println("Сдвиг на " + n + ": ");
        printArray(shift(array, n));

        n = -3;
        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Сдвиг на " + n + ": ");
        printArray(shift(array, n));
        System.out.println();

    }

    // Вывод одномерного массива
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println();
    }

    // Для задания 1 (поменять 0 на 1 и наоборот)
    public static int[] inverse(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.abs(array[i] - 1);
        }
        return array;
    }

    // Для задания 2 (арифм. прогрессия +3)
    public static int[] progression(int[] array) {
        array[0] = 1;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + 3;
        }
        return array;
    }

    // Для задания 3 (умножить на 2 числа меньше 6)
    public static int[] changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        return array;
    }

    // Для задания 4 (макс. число)
    public static int max(int[] array) {
        int maxInt = array[0];
        for (int i = 1; i < array.length; i++) {
            if (maxInt < array[i]) maxInt = array[i];
        }
        return maxInt;
    }

    // Для задания 4 (мин. число)
    public static int min(int[] array) {
        int minInt = array[0];
        for (int i = 1; i < array.length; i++) {
            if (minInt > array[i]) minInt = array[i];
        }
        return minInt;
    }

    // Для задания 5 (заполнить 1-ми диагонали)
    public static int[][] diagonalsEqualOne(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }
        return array;
    }

    // Для задания 6, 7 (сдвиг)
    public static int[] shift(int[] array, int n) {
        for (int j = 0; j < Math.abs(n); j++) {
            if (n > 0) {
                // сдвиг вправо
                for (int i = array.length - 1; i > 0; i--) {
                    int swap = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = swap;
                }
            } else {
                // сдвиг влево
                for (int i = 0; i < array.length - 1; i++) {
                    int swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
        }
        return array;
    }

}
