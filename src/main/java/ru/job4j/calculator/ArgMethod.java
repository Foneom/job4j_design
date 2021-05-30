package ru.job4j.calculator;

public class ArgMethod {

    public static void hello() {
        System.out.println("Hello, ");
    }

    public static void hello(String name, int age) {
        System.out.println("Hello, " + name + ", " + age);
    }

    public static void hello(int age) {
        System.out.println("Hello, " + age);
    }

    public static void hello(String name, String name1, String name2) {
        System.out.println("Hello, " + name + ", " +  name1 + ", "+ name2);
    }

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;

        ArgMethod.hello();

        ArgMethod.hello(name, age);

        ArgMethod.hello(age);

        ArgMethod.hello(name, name, name);
    }
}
