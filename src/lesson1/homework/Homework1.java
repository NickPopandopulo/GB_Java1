package lesson1.homework;

public class Homework1 {

    public static void main(String[] args) {

        // --- Задание № 1 ---
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        double result = calcExpression(a, b, c, d);
        System.out.println("Задание № 1");
        System.out.println("a = " + a + "; b = " + b + "; c = " + c + "; d = " + d);
        System.out.println("a * (b + (c / d)) = " + result + "\n");

        // --- Задание № 2 ---
        a = 1;
        b = 9;
        boolean checking = checkSum(a, b);
        System.out.println("Задание № 2");
        System.out.println("a = " + a + "; b = " + b);
        System.out.println("(10 <= a + b <= 20) == " + checking + "\n");

        // --- Задание № 3 ---
        a = 0;
        String answer = isPositive(a);
        System.out.println("Задание № 3");
        System.out.println("a = " + a);
        System.out.println("а — " + answer + " число\n");

        // --- Задание № 4 ---
        String name = "Nick";
        System.out.println("Задание № 4");
        System.out.println(getGreeting(name) + "\n");

        // --- Задание № 5 ---
        int year = 400;
        System.out.println("Задание № 5");
        System.out.println(year + " — " + isLeapYear(year) + " год\n");

    }

    // Для задания № 1 (вычислить выражение)
    public static double calcExpression(int a, int b, int c, int d) {
        double cc = c;
        return a * (b + (cc / d));
    }

    // Для задания № 2 (сумма в промежутке 10-20)
    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Для задания № 3 (положительное число)
    public static String isPositive(int a) {
        if (a >= 0)
            return "положительное";
        return "отрицательное";
    }

    // Для задания № 4 (приветствие)
    public static String getGreeting(String name) {
        return "Привет, " + name + "!";
    }

    // Для задания № 5 (високосный год)
    public static String isLeapYear(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            return "високосный";
        return "не високосный";
    }

}
