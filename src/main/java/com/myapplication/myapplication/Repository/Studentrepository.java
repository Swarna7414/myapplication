package com.myapplication.myapplication.Repository;

import com.myapplication.myapplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepository extends JpaRepository<Student, Integer> {
}