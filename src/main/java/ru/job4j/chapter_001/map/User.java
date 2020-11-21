package ru.job4j.chapter_001.map;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;
/**
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return children == user.children &&
                name.equals(user.name) &&
                birthday.equals(user.birthday);
    }
*/
    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

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
        User ivan = new User("Ivan", 4, new GregorianCalendar(1978, 3, 1));
        User petr = new User("Ivan", 4, new GregorianCalendar(1978, 3, 1));

        Map<User, Object> users = new HashMap<>();

        users.put(ivan, 1);
        users.put(petr, 2);

        Set set = users.entrySet();

        System.out.println(ivan.hashCode());
        System.out.println(petr.hashCode());
        System.out.println(ivan.equals(petr));
        for (Object o : set) {
            Map.Entry m = (Map.Entry) o;
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}


