package com.uok.mongodb.controller;

import com.uok.mongodb.model.Student;
import com.uok.mongodb.service.StudnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudnetService service;

    @PostMapping("/get")
    public ResponseEntity<CommonResponse> getAllStudents() throws Exception {
        CommonResponse resp = new CommonResponse("success", "Record Loaded", service.getAllStudents());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getStudentByID (@PathVariable String id) throws Exception{
        CommonResponse resp = new CommonResponse("success","Record Loaded.!",service.getStudentById(id));
        return new ResponseEntity(resp,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity createStudent(@RequestBody Student student) throws Exception{
        CommonResponse resp = new CommonResponse("success","Record Created !",service.createStudent(student));
        return new ResponseEntity(resp, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) throws Exception {
        CommonResponse resp = new CommonResponse("success", "Record Updated!", service.updateStudent(id, updatedStudent));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id) throws Exception {
        CommonResponse resp = new CommonResponse("success", service.deleteStudent(id), null);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
