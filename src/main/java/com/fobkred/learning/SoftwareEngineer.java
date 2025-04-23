package com.fobkred.learning;

import java.util.Objects;

public class SoftwareEngineer {
    private int id;
    private  String name;
    private  int age;
    private  String techStack;

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(int id,
                            String name,
                            int age,
                            String techStack) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.techStack = techStack;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return id == that.id && age == that.age && Objects.equals(name, that.name) && Objects.equals(techStack, that.techStack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, techStack);
    }
}
