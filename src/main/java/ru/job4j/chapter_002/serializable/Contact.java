package ru.job4j.chapter_002.serializable;

import java.io.*;
import java.util.Objects;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return zipCode == contact.zipCode &&
                Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode, phone);
    }

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "zipCode=" + zipCode +
                ", phone='" + phone + '\'' +
                '}';
    }
    public static void writeObject(Contact contact, File file) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Contact readObj(File file)  {
        Contact contact = null;
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {
            contact = (Contact) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contact;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");
        File file = new File("data.bin");

        /* Запись объекта в файл */
        writeObject(contact, file);

        /* Чтение объекта из файла */
        Contact contact1 = readObj(file);
        System.out.println(contact1.toString());
        boolean flag1 = contact.toString().equals(contact1.toString());
        boolean flag2 = contact.equals(contact1);
        System.out.println(flag1);
        System.out.println(flag2);
    }
}

