package lesson6.homework;

/*
1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
4. ** Написать метод, проверяющий, есть ли указанное слово в папке
*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Homework6 {

    public static void main(String[] args) {
        String path = "src\\lesson6\\homework\\";
        String file1 = path + "file_1.txt";
        String file2 = path + "file_2.txt";
        String file3 = path + "file_1_2.txt";

        // --- Задание № 2 ---
        mergeFiles(file1, file2, file3);

        // --- Задание № 3 ---
        String word = "события";
        System.out.println("Присутствует ли слово [" + word + "] в файле " + file3 + "? — " + searchWord(word, file3) + "\n");

        // --- Задание № 4 ---
        String pathOfFolder = path + "forSearching";
        String answer;
        word = "String";
        if ((answer = searchWordInFolder(word, pathOfFolder)) != null) {
            System.out.println("Слово [" + word + "] присутствует в файле: " + answer);
        } else {
            System.out.println("Слово [" + word + "] не найдено.");
        }

    }

    public static void mergeFiles(String file1, String file2, String file3) {
        try {
            FileOutputStream fos = new FileOutputStream(file3);
            PrintStream out = new PrintStream(fos, true);

            copyFromFile(file1, out);
            copyFromFile(file2, out);

            out.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFromFile(String file, PrintStream out) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader in = new InputStreamReader(fis, "windows-1251");

        int temp;
        while ((temp = in.read()) != -1) {
            out.print((char) temp);
        }

        out.println();
        in.close();
        fis.close();
    }

    public static boolean searchWord(String word, String file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fis, StandardCharsets.UTF_8);

            int temp;
            while ((temp = in.read()) != -1) {
                if ((char) temp == word.charAt(0)) {
                    int count = 1;
                    for (int i = 1; i < word.length(); i++) {
                        if (in.read() != word.charAt(i)) break;
                        count++;
                    }
                    if (count == word.length()) return true;
                }
            }

            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static String searchWordInFolder(String word, String pathOfFolder) {
        File folder = new File(pathOfFolder);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (searchWord(word, listOfFiles[i].toString())) return listOfFiles[i].toString();
        }

        return null;
    }
    
}
