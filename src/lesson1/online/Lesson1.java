package lesson1.online;

public class Lesson1 {
    public static void main(String[] args) {
//        System.out.println("Hello_all! This is Java! Hello from WinConsole!");
//        System.out.print("Something text!");

//        //С†РµР»РѕС‡РёСЃР»РµРЅРЅС‹Рµ
//        byte myByte = 25; //-128..+127 (1b)
//        short myShort = 250; //-32768..+32767 (2b)
//        int myInt = 50000; //-2.1*10^9..+2.1*10^9 (4b)
//        long myLong = 3000000000L; // -2^63 .. + 2^63 (8b)
//
//        //С‡РёСЃР»Р° СЃ РїР»Р°РІР°СЋС‰РµР№ С‚РѕС‡РєРѕР№
//        float myFloat = 15.8f; // (4b)
//        double myDouble = 15.8; // (8b)
//
//        //СЃРёРјРІРѕР»С‹
//        char myChar = 'q'; // (2b)
//
//        boolean myBoolean = false; //true
//
//        //Math operators: +, -, *, /, ^, %
//
//        int x = 15;
//        int y = 4;
//        int result = x % y;
//        System.out.println(result);
//
//        int abc = 15000;
//        double cde = 152.867;
//        System.out.println(abc + cde);
//
//        String myString = "=^_^=";
//        System.out.println(myString + abc);

//        int myAge = 50;
//
//        if (myAge < 18) {
//            System.out.println("Sorry!!! You can't buy");
//        } else if (myAge > 65) {
//            System.out.println("You old man - go home");
//        } else {
//            System.out.println("You OK!!!!");
//        }

        int a = 150;
        int b = 37;
        int result;

//        result = a * b;
        result = myCalculate(a, b);
        a++; //a = a + 1 -> a++ ||||||  a = a + 5 -> a += 5
        result = myCalculate(a, b);
        b++;
        result = myCalculate(a, b);
        a++;
        result = myCalculate(a, b);

        System.out.println(result); //189

        doSomething();

        check(50, 987);
        humanStep();

    }

    public static int myCalculate(int inputDec, int javaValue) {
        return inputDec + javaValue;
    }

    public static void doSomething() {
        float valueA = 250.987f;
        float valueB = 1002.445f;
        System.out.println(valueA * valueB);
    }

    public static void check(int a, int b) {
        System.out.println(a + b);
    }

    public static void humanStep() {
        System.out.println("Human must go");
    }

}
