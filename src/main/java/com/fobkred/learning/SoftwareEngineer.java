package com.fobkred.learning;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class SoftwareEngineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String techStack;

    @Column(columnDefinition = "TEXT")
    private String learningPathRecommendation;

    // Default constructor
    public SoftwareEngineer() {
    }

    // Constructor with parameters
    public SoftwareEngineer(int id, String name, int age, String techStack, String learningPathRecommendation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.techStack = techStack;
        this.learningPathRecommendation = learningPathRecommendation;
    }

    // Getters and Setters
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

    public String getLearningPathRecommendation() {
        return learningPathRecommendation;
    }

    public void setLearningPathRecommendation(String learningPathRecommendation) {
        this.learningPathRecommendation = learningPathRecommendation;
    }

    // Equals and hashCode for entity comparison
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return id == that.id && age == that.age && Objects.equals(name, that.name) && Objects.equals(techStack, that.techStack) && Objects.equals(learningPathRecommendation, that.learningPathRecommendation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, techStack, learningPathRecommendation);
    }
}