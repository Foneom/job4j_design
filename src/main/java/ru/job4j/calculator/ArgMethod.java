package ru.job4j.calculator;

public class ArgMethod {
    final static String name = "Petr Arsentev";
    final static int age = 33;

    public static void hello() {
        System.out.println("Hello, " + name + ", " + age);
    }

    public static void hello(String name, int age) {
        System.out.println("Hello, " + name + ", " + age);
    }

    public static void hello(int age) {
        System.out.println("Hello, " + name + ", " + age);
    }

    public static void hello(String name, String name1, String name2) {
        System.out.println("Hello, " + name + ", " +  name1 + ", "+ name2);
    }

    public static void main(String[] args) {

        ArgMethod.hello();

        ArgMethod.hello(name, age);

        ArgMethod.hello(age);

        ArgMethod.hello(name, name, name);
    }
}
