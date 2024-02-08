package com.myapplication.myapplication.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void test(){
        Integer roll=20;
        String name="Swarna Sai Sankar";

        List<String> names= Arrays.asList("Swarna","Sai","sankar");

        Map<String, Integer> subjects=new HashMap<>();

        subjects.put("Language",65);
        subjects.put("math",63);
        subjects.put("acience",50);

        Student o=new Student();

        Student o1=new Student(20,"Swarna Sai Sankar",names,subjects);


        o1.setRoll(20);
        o1.setName("Swarna Sai Sankar");
        o1.setNames(names);
        o1.setSubjects(subjects);

        o1.getRoll();
        o1.getName();
        o1.getNames();
        o1.getSubjects();
    }

}