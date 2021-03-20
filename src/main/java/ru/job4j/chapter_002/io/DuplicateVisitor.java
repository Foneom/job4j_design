package ru.job4j.chapter_002.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicateVisitor extends SimpleFileVisitor<Path> {

    private Set<FileProperty> duplicates = new HashSet<>();
    private List<FileProperty> allFiles = new ArrayList<>();

    public static <T> Set<T> findDuplicates(Collection<T> collection) {
        Set<T> elements = new HashSet<>();
        return collection.stream()
                .filter(e -> !elements.add(e))
                .collect(Collectors.toSet());
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long size = Files.walk(file).mapToLong(p -> p.toFile().length()).sum();
        FileProperty fp = new FileProperty(size, file.getFileName().toString());
        allFiles.add(fp);
        duplicates = findDuplicates(allFiles);
        for (FileProperty f : duplicates)
            System.out.println(f.getName() + " - " + f.getSize() + " - " + file.toFile().getAbsolutePath());

        return FileVisitResult.CONTINUE;
    }
}

class DuplicateFinder {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Path.of("./"), new DuplicateVisitor());
    }
}

class FileProperty {

    private long size;

    private String name;

    public FileProperty(long size, String name) {
        this.size = size;
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileProperty that = (FileProperty) o;
        return size == that.size && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}
