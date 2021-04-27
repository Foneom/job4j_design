package ru.job4j.chapter_002.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private String botAnswers;
    private static final List<String> finalList = new ArrayList<>();
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final Scanner scanner;
    private final Random random;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        this.scanner = new Scanner(System.in);
        this.random = new Random();

    }

    public String readFile(String botAns) {
        ArrayList<String> list = new ArrayList<>();
        int randomIndex = 0;
        String line;
        try (BufferedReader br = new BufferedReader(
                new FileReader(botAns, StandardCharsets.UTF_8))) {
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            randomIndex = random.nextInt(list.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.get(randomIndex);
    }

    /**
     * Запись чата в файл
     *
     * @param file
     */
    public void writeDataInFile(String file) {
        try {
            Files.write(Paths.get(file), finalList, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String msg = "";
        String botAnswer = readFile(botAnswers);
        do {
            msg = scanner.nextLine();
            finalList.add(msg);
            if (msg.equals(OUT)) {
                break;
            } else if (msg.equals(STOP)) {
                while (!msg.equals(CONTINUE)) {
                    msg = scanner.nextLine();
                    finalList.add(msg);
                }
            } else {
                System.out.println(botAnswer);
                finalList.add(botAnswer);
            }
            writeDataInFile(path);
        } while (true);
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./path.txt", "./botAnswers.txt");
        cc.run();
    }
}
