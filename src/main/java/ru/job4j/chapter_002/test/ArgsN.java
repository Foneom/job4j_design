package ru.job4j.chapter_002.test;

import ru.job4j.chapter_002.io.ArgsName;

import java.util.HashMap;
import java.util.Map;

public class ArgsN {
    private final Map<String, String> values = new HashMap<>();

    public static ArgsN of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("");
        }
        ArgsN names = new ArgsN();
        names.parse(args);
        return names;
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
