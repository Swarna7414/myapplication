package com.myapplication.myapplication.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Student_details")
public class Student {

    @Id
    private Integer roll;

    private String name;

    @ElementCollection
    @CollectionTable(name = "Student_names" , joinColumns = @JoinColumn(name = "student_roll"))
    @Column(name = "names")
    private List<String> names;


    @ElementCollection
    @CollectionTable(name = "Student_subjects", joinColumns = @JoinColumn(name = "student_roll"))
    @MapKeyColumn(name="subject_name")
    @Column(name = "subject_marks")
    private Map<String, Integer> subjects;

    public Student() {
    }

    public Student(String name){
        this.name=name;
    }

    public Student(Integer roll, String name, List<String> names, Map<String, Integer> subjects) {
        this.roll = roll;
        this.name = name;
        this.names = names;
        this.subjects = subjects;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<String, Integer> subjects) {
        this.subjects = subjects;
    }
}
