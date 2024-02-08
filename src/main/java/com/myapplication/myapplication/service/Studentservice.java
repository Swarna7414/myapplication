package com.myapplication.myapplication.service;

import com.myapplication.myapplication.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Studentservice {
    public ResponseEntity<Object> createdetails(Student student);

    public ResponseEntity<Object> getdetail(Integer roll);

    public List<Student> getalldetails();

    public void updatedetails(Student updatedstudent);

    public void deletedetails(Integer roll);
}
