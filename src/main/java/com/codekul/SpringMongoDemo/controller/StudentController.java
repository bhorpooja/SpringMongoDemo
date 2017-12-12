package com.codekul.SpringMongoDemo.controller;

import com.codekul.SpringMongoDemo.model.Book;
import com.codekul.SpringMongoDemo.model.Student;
import com.codekul.SpringMongoDemo.repo.BookRepo;
import com.codekul.SpringMongoDemo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pooja on 5/12/17.
 */

@RestController
public class StudentController {

    public static final String STATUS="status";
    public static final String FAIL="fail";
    public static final String SUCCESS="success";
    public static final String MESSAGE="msg";

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private BookRepo bookRepo;

    @PostMapping("/insertStudent")
    public ResponseEntity<?> insertStudent(@RequestBody Student student){
        Map<String,Object> map=new HashMap<>();
        ResponseEntity<Map<String,Object>> entity=null;
        studentRepo.save(student);
        map.put(STATUS,SUCCESS);
        map.put("userId",student);
        map.put(MESSAGE,"Student Inserted Successfully");
        entity=new ResponseEntity<>(map, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/getStudent")
    public List<Student> getStudent(){
       List<Student> student=studentRepo.findAll();
        return student;
    }

    @GetMapping("/getStudent1/{name}")
    public Student getStudent1(@PathVariable String name){
        Student student=studentRepo.findByName(name);
        return student;
    }

    @GetMapping("/updateStudent/{name}/{city}")
    public String getStudent2(@PathVariable String name,@PathVariable String city){
        Student student=studentRepo.findByName(name);
        student.setCity(city);
        studentRepo.save(student);
        return "Student Updated Successfully";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student){
        Student objStud= studentRepo.findByName(student.getName());
        objStud.setCity(student.getCity());
        objStud.setName(student.getName());
        studentRepo.save(objStud);
        return "Student updated";
    }

    @PostMapping("/deleteStudent/{name}")
    public String deleteStudent(@PathVariable String name){
        Student objStud= studentRepo.findByName(name);
        studentRepo.delete(objStud);
        return "Student deleted";
    }

    @PostMapping("/saveBookRef")
    public String saveBook(@RequestBody Student student){
        Book book=bookRepo.findByName(student.getBook().getName());
        studentRepo.save(student);
        return "Student Saved Successfully";
    }

    @GetMapping("/getStudentBookRef/{city}")
    public Student getStudentBookRef(@PathVariable String city){

        Student objStud = studentRepo.findByCity(city);
        return objStud;
    }

    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Book book){
       bookRepo.save(book);
        return "Book saved";
    }

    @GetMapping("/textSearch/{searchData}")
    public List<Student> textSearch(@PathVariable String searchData){
        List<Student> student=studentRepo.find(searchData);
        return student;
    }






}
