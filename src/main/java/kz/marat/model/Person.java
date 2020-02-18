package kz.marat.model;

import java.util.ArrayList;

public class Person {
    private int id;
    private String name;
    private int age;
    private int legSize;
    private String sex;
    private String status;

    public Person() {

    }

    public Person(int id,String name, int age, int legSize, String sex, String status) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.legSize = legSize;
        this.sex = sex;
        this.status = status;
    }
    public Person(String name, int age, int legSize, String sex, String status) {
        this.age = age;
        this.name = name;
        this.legSize = legSize;
        this.sex = sex;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public int getLegSize() {
        return legSize;
    }

    public String getSex() {
        return sex;
    }

    public String getStatus() {
        return status;
    }

    public void setLegSize(int legSize) {
        this.legSize = legSize;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public int pensiya() {
        int let = 63 - this.age;
        if (this.age > 63) {
            return 0;
        } else
            return let;
    }

}
