package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path = "/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    @RequestMapping(path = "/addDefaultStudent")
    public String addDefaultStudent(){
        return studentService.addDefaultStudent() == true ? "user added" : "error, user not added";
    }

    @PostMapping
    @RequestMapping(path = "/addCustomStudent")
    public String addCustomStudent(@RequestBody Student student){
        return studentService.addCustomStudent(student);
    }

    @DeleteMapping
    @RequestMapping(path = "/deleteUserByEmail")
    public String deleteUserByEmail(@RequestBody Student student){
        return studentService.deleteUserByEmail(student);
    }

    @DeleteMapping(path = "deleteUserById/{id}")
    public String deleteUserById(@PathVariable Long id){
        return studentService.deleteUserById(id);
    }

    @PutMapping
    @RequestMapping(path = "/updateUserEmail")
    public String updateUserEmail(@RequestBody Map<String, String> json){
        return studentService.updateUserEmail(json);
    }

}
