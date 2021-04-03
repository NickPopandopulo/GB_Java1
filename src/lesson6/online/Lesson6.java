package Lesson06.online;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 03.04.2021
 */

public class Lesson6 extends Object {

//    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        String s0 = "Hello_world";
//        String s1 = "Hello";
//        s1 += "_world";
//        String s2 = scanner.nextLine();
//        String s3 = "Hello_world";
//
//        System.out.println(s0 == s1);
//        System.out.println(s0 == s2);
//        System.out.println(s0 == s3);
//        System.out.println("******");
//        System.out.println(s0.equals(s1));
//        System.out.println(s0.equals(s2));
//        System.out.println(s0.equals(s3));


//        String exampleString = "Example"; //String exampleString = new String("Example");
//
//        long startTime = System.nanoTime();
//
//        for (int i = 0; i < 50000; i++) {
//            exampleString += i;
//        }
//
//        float deltaTime = System.nanoTime() - startTime;
//        System.out.println(exampleString);
//        System.out.println("Work time string > " + deltaTime * 0.000001f + " millisec");
//
//        StringBuilder exampleSB = new StringBuilder("Example");
//        startTime = System.nanoTime();
//
//        for (int i = 0; i < 50000; i++) {
//            exampleSB.append(i);
//        }
//
//        deltaTime = System.nanoTime() - startTime;
//        System.out.println(exampleSB.toString());
//        System.out.println(exampleString.equals(exampleSB.toString()));
//        System.out.println("Work time exampleSB > " + deltaTime * 0.000001f + " millisec");
//
//        StringBuffer stringBuffer = new StringBuffer();
//        System.out.println("Program start");
//
//        int a = 10;
//        int b = 0;
//
//        try {
//            System.out.println("result = " + a / b);
//        } catch (ArithmeticException exception) {
//            System.err.println("Here error: " + exception.getMessage());
//        }
//
//        try {
//            doSomething(a, b);
//        } catch (IOException exception) {
//            System.out.println("I catch");
//        }
//
//        System.out.println("Program end");
//
//        InputStream inputStream;
//        OutputStream outputStream;
//
//        FileInputStream fis;
//        FileOutputStream fos;

        String nameOurFile = "TestFile01.txt";

        writeToFile(nameOurFile);
//        readFromFile(nameOurFile);
//            fileOutputStream.write(78);
//            fileOutputStream.write(79);
//            fileOutputStream.write(80);
//            fileOutputStream.write(81);


    }

    private static void writeToFile(String nameFile) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(nameFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.print("654654654645!\n");
            printStream.flush();
            printStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("ERROR: File not found");
        } catch (IOException exception) {
            System.out.println("ERROR: IOException");
        }
    }

    private static void readFromFile(String nameFile) {
        try {
        FileInputStream fileInputStream = new FileInputStream(nameFile);

        int tmp;

        while((tmp = fileInputStream.read()) != -1) {
            System.out.print((char) tmp);
        }
        fileInputStream.close();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("ERROR: File not found");
        } catch (IOException exception) {
            System.out.println("ERROR: IOException");
        }
    }

//    public static void doSomething(int a, int b) throws IOException {
//        ///***
//            throw new IOException();
//    }
}

/*
1.	Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
2.	Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
3.	* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
4.  ** Написать метод, проверяющий, есть ли указанное слово в папке
*/
