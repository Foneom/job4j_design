package ru.job4j.chapter_002.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

        public static void unavailable(String source, String target) throws IOException {

            StringBuilder stringForTime = new StringBuilder();
            List<String> log = new ArrayList<>();
            boolean marker = false;

            try (BufferedReader in = new BufferedReader(new FileReader(source))) {
                String line;
                while ((line = in.readLine()) != null) {
                    if (!marker && (line.startsWith("400") || line.startsWith("500"))) {
                        marker = true;
                        stringForTime = new StringBuilder(line + " - ");
                    }
                    if (marker && line.startsWith("200")) {
                        marker = false;
                        stringForTime.append(line).append(System.lineSeparator());
                        log.add(stringForTime.toString());
                        stringForTime = new StringBuilder();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                log.forEach(out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
