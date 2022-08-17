package com.example.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(new Student("Slava",22,"slava@gmail.com", LocalDate.of(1999, Month.NOVEMBER,04)));
    }
}
