package ru.job4j.chapter_002.io;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.*;


public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenPairWithoutComment() throws IOException {
        File source = folder.newFile("log_server.txt");
        File target = folder.newFile("unavailable.csv");
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.write("200 10:56:01" + System.lineSeparator()
                    + "500 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "200 10:59:01" + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator()
                    + "200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(target))) {
            fileReader.lines().forEach(builder::append);
        }
        String rsl = builder.toString();
        assertThat(
                rsl,
                is("500 10:57:01 - 200 10:59:01" + "500 11:01:02 - 200 11:02:02")
        );
    }
}