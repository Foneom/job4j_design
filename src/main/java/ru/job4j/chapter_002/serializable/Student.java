package ru.job4j.chapter_002.serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.txw2.annotation.XmlElement;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.*;


@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlAttribute
    private boolean isExcellent;
    @XmlAttribute
    private int groupNumber;
    @XmlAttribute
    private String faculty;

    private Passport passport;
    private int[] progress;

    public Student() {
    }

    ;

    public Student(boolean isExcellent, int groupNumber, String faculty, Passport passport, int[] progress) {
        this.isExcellent = isExcellent;
        this.groupNumber = groupNumber;
        this.faculty = faculty;
        this.passport = passport;
        this.progress = progress;
    }

    public boolean isExcellent() {
        return isExcellent;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public Passport getPassport() {
        return passport;
    }

    public int[] getProgress() {
        return progress;
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

    public static void toJsn(Student student) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(student);
        System.out.println(json);


        Student read = gson.fromJson(json, Student.class);
        System.out.println(read);
    }

    public static String serialization(Student student, JAXBContext context) {
        String xml = "";
        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter writer = new StringWriter();
            marshaller.marshal(student, writer);
            xml = writer.getBuffer().toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }

    public static Student deSerialization(JAXBContext context, String xml) {
        Student result = null;
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            result = (Student) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws JAXBException {
        Passport passport =  new Passport("Ivan", "Petrov", 19, "male");
        Student student = new Student(false, 14, "Transport",
                passport, new int[]{4, 3, 3, 5});

        JAXBContext context = JAXBContext.newInstance(Student.class);

        String xml = serialization(student, context);
        Student result = deSerialization(context, xml);

       // System.out.println(xml);
       // System.out.println(result);

        JSONObject jsonPassport = new JSONObject();
        jsonPassport.put("name", passport.getName());
        jsonPassport.put("surname", passport.getSurname());
        jsonPassport.put("age", passport.getAge());
        jsonPassport.put("gender", passport.getGender());

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(3);
        list.add(5);

        JSONObject jsonProgress = new JSONObject(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("excellent", student.isExcellent());
        jsonObject.put("groupNumber", student.getGroupNumber());
        jsonObject.put("faculty", student.getFaculty());
        jsonObject.put("passport", jsonPassport);
        jsonObject.put("progress", jsonProgress);

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(student).toString());
    }
}

@XmlElement
class Passport {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private String surname;
    private int age;
    @XmlAttribute
    private String gender;

    public Passport() {
    }

    public Passport(String name, String surname, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
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


