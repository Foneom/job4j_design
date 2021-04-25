package ru.job4j.chapter_002.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.*;


public class Zip {

    public static List<Path> seekBy(String root, String ext) {
        List<Path> list = new ArrayList<>();
        Path path = Paths.get(root);
        try {
            list = Search.search(path, ext);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(List<Path> filteredFiles, ZipOutputStream zos) {

        for (Path path : filteredFiles) {
            if (path.toFile().isDirectory()) {
                System.out.println("Добавление директории: " + path.toFile().getName());
                continue;
            }
            System.out.println("Добавление файла: " + path.toFile().getName());
            try (FileInputStream fis = new FileInputStream(path.toFile())) {
                zos.putNextEntry(new ZipEntry(path.toFile().getPath()));
                fis.transferTo(zos);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pack(String root, String zipFile, String ext) {

        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)))) {

            add(seekBy(root, ext), zip);
            zip.close();
            System.out.println("Zip файл создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        Zip zip = new Zip();
        zip.pack(argsName.get("d"), argsName.get("o"), argsName.get("e"));
    }
}