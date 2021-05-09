package ru.job4j.chapter_002.test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class Find {

    private String name;
    private static Predicate<Path> predicate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Path> search(Path root, String name) throws IOException {
        SearchFile searcher = new SearchFile(predicate);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static List<Path> seekBy(String root, String name) {
        List<Path> list = new ArrayList<>();
        Path path = Paths.get(root);
        try {
            list = search(path, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void fileWrt(List<Path> list, String fileWriteName) {
        try (FileWriter fileWriter = new FileWriter(fileWriteName)) {
            for (Path path : list) {
                fileWriter.write((path.getParent() + " - " + path.getFileName())
                        + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findF(String root, String fileName, String fileWriteName, String fileSearcherType) {
        List<Path> result;
        if (fileSearcherType.equals("name")) {
            predicate = p -> p.toFile().getName().contains(fileName);
            result = seekBy(root, fileName);
        } else if (fileSearcherType.equals("mask")) {
            predicate = path -> path.toFile().getName().endsWith(fileName);
            result = seekBy(root, fileName);
        } else {
           throw new IllegalArgumentException("Argument not true");
        }
        fileWrt(result, fileWriteName);
    }

    public static void main(String[] args) throws IOException {
        ArgsN argsN = ArgsN.of(args);
        Find find = new Find();
        find.findF(argsN.get("d"), argsN.get("o"), argsN.get("e"), argsN.get("t"));
        System.out.println(argsN.get("o"));

    }
}
