package ru.job4j.chapter_001.map;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public static void main(String[] args) {
        User ivan = new User("Ivan", 4, Calendar.getInstance());
        User petr = new User("Petr", 2, Calendar.getInstance());

        Map<User, Object> users = new HashMap<>();

        users.put(ivan, 1);
        users.put(petr, 2);

        for (Map.Entry<User, Object> user : users.entrySet()) {
            System.out.println(user.getKey().getName() + " - " + user.getValue());
        }
        }
    }


