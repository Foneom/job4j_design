package ru.job4j.chapter_002.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleFileOutput {

    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i <= table.length; i++) {
            for (int j = 1; j <= table.length; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }

    public static void main(String[] args) throws FileNotFoundException {
        SimpleFileOutput file = new SimpleFileOutput();
        FileOutputStream fileOutputStream = null;
        int[][] result = file.multiple(3);
        try {
            fileOutputStream = new FileOutputStream("result.txt");
            for (int[] v : result) {
                String str = Arrays.toString(v) + "\n";
                fileOutputStream.write(str.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
