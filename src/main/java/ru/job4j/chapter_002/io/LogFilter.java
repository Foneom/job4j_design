package ru.job4j.chapter_002.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
