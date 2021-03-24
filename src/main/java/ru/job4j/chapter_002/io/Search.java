package ru.job4j.chapter_002.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, "").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        if (!root.toFile().exists()) {
            throw new IllegalArgumentException("Root folder is not exist.");
        } else if (ext == null) {
            throw new IllegalArgumentException("File extension is null");
        }
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}