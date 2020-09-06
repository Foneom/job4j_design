package ru.job4j.chapter_002.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleFileInput {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = null;
        int b = 0;
        ArrayList<Character> list = new ArrayList<>();
        try {
            fis = new FileInputStream("D:/test.txt");
            while ((b = fis.read()) != -1) {
                if ((char) b % 2 == 0) {
                    System.out.print((char) b);
                }
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
