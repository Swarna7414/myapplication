package com.myapplication.myapplication.service.impl;

import com.myapplication.myapplication.Repository.Studentrepository;
import com.myapplication.myapplication.exception.Studentnotfoundexception;
import com.myapplication.myapplication.model.Student;
import com.myapplication.myapplication.service.Studentservice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentserviceimplTest {

    @Mock
    private Studentrepository studentrepository;

    @InjectMocks
    private Studentserviceimpl studentserviceimpl;

    private Student student;

    private Student student1;

    AutoCloseable autoCloseable;



    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        List<String> names= Arrays.asList("Swarna","Sai","sankar");
        Map<String, Integer> subjects=new HashMap<>();
        subjects.put("Language",65);
        subjects.put("math",63);
        subjects.put("acience",50);
        student = new Student(20,"Swarna Sai Sankar",names,subjects);
         student1 =new Student(22,"Swarna uday Sankar",names,subjects);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void createdetails() {
        mock(Student.class);
        mock(Studentrepository.class);

        when(studentrepository.save(student)).thenReturn(student);
        studentserviceimpl.createdetails(student);
    }


    @Test
    void getalldetails() {
        mock(Student.class);
        mock(Studentrepository.class);

        when(studentrepository.findAll()).thenReturn(Arrays.asList(student,student1));
        studentserviceimpl.getalldetails();
    }

    @Test
    void updatedetails() {
        mock(Student.class);
        mock(Studentrepository.class);

        List<String> updatedone= Arrays.asList("s","s","sanksar");

        Map<String, Integer> labs=new HashMap<>();
        labs.put("Language",65);
        labs.put("math",63);
        labs.put("acience",50);

        Integer nroll= 20;

        Student updatedstudent = new Student(20,"Vishnu",updatedone,labs);
        when(studentrepository.findById(nroll)).thenReturn(Optional.ofNullable(student));
        when(studentrepository.save(updatedstudent)).thenReturn(updatedstudent);

        studentserviceimpl.updatedetails(updatedstudent);

        Integer roll = 20;
        when(studentrepository.findById(roll)).thenReturn(Optional.empty());

        Studentnotfoundexception studentnotfoundexception = assertThrows(Studentnotfoundexception.class, () -> studentserviceimpl.getdetail(roll));

        assertThat(studentnotfoundexception.getMessage()).isEqualTo("Student Id not found in repostory");

    }

    @Test
    void deletedetails(){
        Integer roll=20;

        doNothing().when(studentrepository).deleteById(roll);

        studentserviceimpl.deletedetails(roll);

    }


}