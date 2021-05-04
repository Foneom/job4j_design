package ru.job4j.chapter_002.serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Student {
    private boolean isExcellent;
    private int groupNumber;
    private String faculty;
    private Passport passport;
    private int[] progress;

    public Student(boolean isExcellent, int groupNumber, String faculty, Passport passport, int[] progress) {
        this.isExcellent = isExcellent;
        this.groupNumber = groupNumber;
        this.faculty = faculty;
        this.passport = passport;
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "isExcellent=" + isExcellent +
                ", groupNumber=" + groupNumber +
                ", faculty='" + faculty + '\'' +
                ", passport=" + passport.toString() +
                ", progress=" + Arrays.toString(progress) +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student(false, 14, "Transport",
                new Passport("Ivan", "Petrov", 19, "male"), new int[]{4, 3, 3, 5});

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(student);
        System.out.println(json);


        Student read = gson.fromJson(json, Student.class);
        System.out.println(read);


    }
}

class Passport {
    private String name;
    private String surname;
    private int age;
    private String gender;

    public Passport(String name, String surname, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}


