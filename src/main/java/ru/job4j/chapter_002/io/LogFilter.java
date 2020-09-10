package ru.job4j.chapter_002.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) throws IOException {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(file))) {
            List<String> line = bufferedReader.lines()
                    .filter(lin -> lin.contains("404"))
                    .collect(Collectors.toList());
            line.stream().forEach(System.out::println);
            return line;
        }
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String o : log) {
                out.write(o + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> log = filter("log.txt");
        save(log, "result.txt");
        System.out.println(log);
    }
}
