package com.uok.mongodb.service;

import com.uok.mongodb.model.Student;
import com.uok.mongodb.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudnetService {
    @Autowired
    StudentRepo Repo;

    public Student createStudent(Student student) throws Exception{
        return Repo.save(student);
    }

    public List<Student> getAllStudents() throws Exception{
        return Repo.findAll();
    }
    public Student getStudentById(String id) throws Exception{
        return Repo.findById(id).orElseThrow(() -> new Exception("Student not found with ID: " + id));
    }



}