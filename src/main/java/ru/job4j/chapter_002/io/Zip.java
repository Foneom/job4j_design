package ru.job4j.chapter_002.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zip {

    public void addDirectory(ZipOutputStream zout, File source, String ext) {
        FileInputStream fis = null;

        File[] files = source.listFiles();
        System.out.println("Добавление директории: " + source.getName());
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                addDirectory(zout, files[i], ext);
                continue;
            }

            if (!files[i].getName().endsWith(ext)) {
                System.out.println("Добавление файла: " + files[i].getName());

                try {
                    fis = new FileInputStream(files[i]);

                    zout.putNextEntry(new ZipEntry(files[i].getPath()));

                    byte[] buffer = new byte[fis.available()];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        zout.write(buffer, 0, length);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        zout.closeEntry();
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void packZip(String source, String zip, String ext) {
        FileOutputStream fout;
        ZipOutputStream zout = null;

        try {
            fout = new FileOutputStream(zip);
            zout = new ZipOutputStream(fout);
            File fileSource = new File(source);

            addDirectory(zout, fileSource, ext);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zout.close();
                System.out.println("Zip файл создан!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        Zip zip = new Zip();
        zip.packZip(argsName.get("d"), argsName.get("o"), argsName.get("e"));
    }
}