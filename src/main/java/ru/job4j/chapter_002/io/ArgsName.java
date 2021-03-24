package ru.job4j.chapter_002.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-out=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("encoding"));

        ArgsName zip = ArgsName.of(new String[]{"-out=512", "-encoding=UTF-8"});
        System.out.println(zip.get("encoding"));
    }

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String arg : args) {
            String[] parts = arg.split("=", 2);
            if (parts.length != 2) {
                throw new IllegalArgumentException("");
            }
            String key = parts[0];
            if (key.startsWith("-")) {
                key = key.substring(1);
            }
            String value = parts[1];
            if (value.equals("")) {
                throw new IllegalArgumentException("");
            }
            values.put(key, value);
        }
    }
}
