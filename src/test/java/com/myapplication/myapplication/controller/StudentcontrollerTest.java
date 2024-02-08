package com.myapplication.myapplication.controller;

import com.myapplication.myapplication.model.Student;
import com.myapplication.myapplication.service.impl.Studentserviceimpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentcontrollerTest {

    @Mock
    Studentserviceimpl studentserviceimpl;

    @InjectMocks
    Studentcontroller studentcontroller;

    private Student student;

    AutoCloseable autoCloseable;

    private Student student1;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        List<String> names= Arrays.asList("Swarna","Sai","sankar");
        Map<String, Integer> subjects=new HashMap<>();
        subjects.put("Language",65);
        subjects.put("math",63);
        subjects.put("acience",50);
        student = new Student(20,"Swarna Sai Sankar",names,subjects);

        List<String> names1= Arrays.asList("Swarna","Sai","sankar");
        Map<String, Integer> subject=new HashMap<>();
        subject.put("Language",65);
        subject.put("math",63);
        subject.put("acience",50);
        student1= new Student(45,"Swarna Uday Sankar",names1,subject);

    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }
    @Test
    void createdetails(){
        when(studentserviceimpl.createdetails(student)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).build());
        ResponseEntity<Object> responseEntity = studentcontroller.createdetails(student);
        assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
    }

    @Test
    void getdetail(){
        when(studentserviceimpl.getdetail(student.getRoll())).thenReturn(ResponseEntity.ok(student));

        ResponseEntity<Object> result= studentcontroller.getdetails(20);

        assertEquals(ResponseEntity.ok(student),result);

    }


    @Test
    void getalldetails() {


        List<Student> expectedstudents= Arrays.asList(student,student1);

        when(studentserviceimpl.getalldetails()).thenReturn(expectedstudents);

        List<Student> results = studentcontroller.getalldetails();

        assertEquals(results.size(),expectedstudents.size());

    }

    @Test
    void updatedetails() {

        String result=studentcontroller.updatedetails(student1);

        assertEquals("Successfully updated",result);

    }

    @Test
    void deletedetails(){
        String result = studentcontroller.deletedetails(20);

        assertEquals("Details Deleted successfully",result);
    }
}