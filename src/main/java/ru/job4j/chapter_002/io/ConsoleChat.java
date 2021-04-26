package ru.job4j.chapter_002.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
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
                new InputStreamReader(
                        new FileInputStream(botAns)))) {
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
            Files.write(Paths.get(file), finalList, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String msg = "";
        do {
            msg = scanner.nextLine();
            if (msg.equals(OUT)) {
                System.exit(0);
            } else if (msg.equals(STOP)) {
                do {
                    msg = scanner.nextLine();
                    finalList.add(msg);
                } while (msg.equals(CONTINUE));
            } else {
                finalList.add(msg);
                System.out.println(readFile(botAnswers));
                finalList.add(readFile(botAnswers));
            }
            writeDataInFile(path);
        } while (true);
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./path.txt", "./botAnswers.txt");
        cc.run();
    }
}
