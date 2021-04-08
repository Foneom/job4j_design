package ru.job4j.chapter_002.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.*;
import java.util.List;


public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(target))) {
            for (Path source : sources) {
                if (source.toFile().isDirectory()) {
                    packFiles(sources, target);
                    continue;
                }
                try (FileInputStream fis = new FileInputStream(source.toFile())) {
                    zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                    byte[] buffer = new byte[fis.available()];
                    while (fis.read(buffer) > 0)
                        zip.write(buffer);
                    zip.closeEntry();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Path> seekBy(String root, String ext) {
        List<Path> fileList = new ArrayList<>();
        Path path = Paths.get(root);
        try {
            new Search().search(path, ext);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileList;
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(new String[]{"-d=project.zip",
                "-e=xml", "-o=C:\\Users\\lenovo\\IdeaProjects\\Zip"});
        Zip zip = new Zip();
        List<Path> list = zip.seekBy(argsName.get("o"), argsName.get("e"));
        zip.packFiles(list, new File(argsName.get("e")));
    }
}