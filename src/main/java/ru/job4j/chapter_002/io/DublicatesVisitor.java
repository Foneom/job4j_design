package ru.job4j.chapter_002.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DublicatesVisitor extends SimpleFileVisitor<Path> {

    public static void main(String[] args) {
        Map<FileProperty, List<FileProperty>> duplicates = new HashMap<>();
        DublicatesVisitor.handleDirectory(duplicates, new File(""));
        Iterator<Map.Entry<FileProperty, List<FileProperty>>> iterator = duplicates.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<FileProperty, List<FileProperty>> next = iterator.next();
            if (next.getValue().size() == 0) {
                iterator.remove();
            } else {
                System.out.println(next.getKey().getName() + " - " + next.getKey().getAbsolutePath());
                for (final FileProperty fil : next.getValue()) {
                    System.out.println(fil.getName() + " - " + fil.getAbsolutePath());
                }
            }
        }
    }

    private static void handleDirectory(final Map<FileProperty, List<FileProperty>> duplicates, final File directory) {
        final File dir = directory;
        if (dir.isDirectory()) {
            final File[] files = dir.listFiles();
            for (final File file : files) {
                if (file.isDirectory()) {
                    DublicatesVisitor.handleDirectory(duplicates, file);
                    continue;
                }
                final FileProperty myFile = new FileProperty(file.getAbsolutePath());
                if (!duplicates.containsKey(myFile)) {
                    duplicates.put(myFile, new Vector<>());
                } else {
                    duplicates.get(myFile).add(myFile);
                }
            }
        }
    }


    static class FileProperty extends File {

        public FileProperty(final String pathname) {
            super(pathname);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final FileProperty other = (FileProperty) o;
            if (!Arrays.equals(this.getContent(), other.getContent())) {
                return false;
            }
            if (this.getName() == null) {
                if (other.getName() != null) {
                    return false;
                }
            } else if (!this.getName().equals(other.getName())) {
                return false;
            }
            if (this.length() != other.length()) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = prime;
            result = (prime * result) + Arrays.hashCode(this.getContent());
            result = (prime * result) + ((this.getName() == null) ? 0 : this.getName().hashCode());
            result = (prime * result) + (int) (this.length() ^ (this.length() >>> 32));
            return result;
        }

        private byte[] getContent() {
            try (final FileInputStream fis = new FileInputStream(this)) {
                return fis.readAllBytes();
            } catch (final IOException e) {
                e.printStackTrace();
                return new byte[]{};
            }
        }
    }
}