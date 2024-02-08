package com.myapplication.myapplication.service.impl;

import com.myapplication.myapplication.Repository.Studentrepository;
import com.myapplication.myapplication.exception.Studentnotfoundexception;
import com.myapplication.myapplication.model.Student;
import com.myapplication.myapplication.response.Createresponsehandler;
import com.myapplication.myapplication.response.Responsehandler;
import com.myapplication.myapplication.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studentserviceimpl implements Studentservice {

    @Autowired
    Studentrepository studentrepository;

    @Override
    public ResponseEntity<Object> createdetails(Student student) {

        studentrepository.save(student);
        return Createresponsehandler.cres("Student Id created",HttpStatus.CREATED,student);
    }

    @Override
    public ResponseEntity<Object> getdetail(Integer roll) {

        if (studentrepository.findById(roll).isEmpty()){
            throw new Studentnotfoundexception("Student Id not found in repostory");
        }

        else {
            return Responsehandler.res("Detals found", HttpStatus.OK, studentrepository.findById(roll).get());
        }
    }

    @Override
    public List<Student> getalldetails() {
        return studentrepository.findAll();
    }

    @Override
    public void updatedetails(Student updatedstudent) {
        Integer id= updatedstudent.getRoll();
        Student existingstudent = studentrepository.findById(id).orElse(null);

        if(existingstudent!=null){
            existingstudent.setName(updatedstudent.getName());
            existingstudent.setNames(updatedstudent.getNames());
            existingstudent.setSubjects(updatedstudent.getSubjects());

            studentrepository.save(existingstudent);
        }

    }

    @Override
    public void deletedetails(Integer roll) {
        studentrepository.deleteById(roll);
    }

}