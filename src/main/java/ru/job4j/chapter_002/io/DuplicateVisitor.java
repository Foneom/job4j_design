package ru.job4j.chapter_002.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicateVisitor extends SimpleFileVisitor<Path> {

    private Set<FileProperty> all = new HashSet<>();
    private List<Path> duplicates = new ArrayList<>();

    public List<Path> getDuplicates() {

        return duplicates;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        File f = file.toFile();
        FileProperty fp = new FileProperty(f.length(), f.getName());
        if (!all.add(fp)) {
            duplicates.add(file);
        }
        System.out.println(getDuplicates());
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
