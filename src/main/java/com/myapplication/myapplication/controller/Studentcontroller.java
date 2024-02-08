package com.myapplication.myapplication.controller;

import com.myapplication.myapplication.model.Student;
import com.myapplication.myapplication.service.impl.Studentserviceimpl;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realstudent")
public class Studentcontroller {

    @Autowired
    Studentserviceimpl studentserviceimpl;
    @PostMapping
    public ResponseEntity<Object> createdetails(@RequestBody Student student){
        return studentserviceimpl.createdetails(student);
    }

    @GetMapping("{roll}")
    public ResponseEntity<Object> getdetails(@PathVariable Integer roll){
        return studentserviceimpl.getdetail(roll);
    }

    @GetMapping
    public List<Student> getalldetails(){
        return studentserviceimpl.getalldetails();
    }

    @PutMapping
    public String updatedetails(@RequestBody Student updatedstudent){
        studentserviceimpl.updatedetails(updatedstudent);
        return "Successfully updated";
    }

    @DeleteMapping("{roll}")
    public String deletedetails(@PathVariable Integer roll){
        studentserviceimpl.deletedetails(roll);
        return "Details Deleted successfully";
    }

}
