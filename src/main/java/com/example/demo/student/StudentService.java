package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {


    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
        //return List.of(new Student("Slava","Verchonov","slava@gmail.com",22));
    }

    public Boolean addDefaultStudent(){
        double a = Math.random()*99+1;
        try {
            studentRepository.save(new Student("Slava","Verchonov",""+a+"@gmail.com", LocalDate.of(1999, Month.NOVEMBER,04)));
            return true;
        }catch (Exception e){
            return false;
        }
        //return List.of(new Student("Slava","Verchonov","slava@gmail.com",22));
    }


    public String addCustomStudent(Student student) {
        try {
            if(!studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
                studentRepository.save(student);
                return "user added";
            }else{
                return "user already registered";
            }

        }catch (Exception e){
            return "wrong request or internal error";
        }
    }

    public String deleteUserByEmail(Student student) {
        //return " " + ;studentRepository.findStudentByEmail(student.getEmail()).get().getEmail()
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            studentRepository.deleteById(studentRepository.findStudentByEmail(student.getEmail()).get().getId());
            return "user deleted";
        }else{
            return "user cannot be deleted";
        }
    }

    @Transactional
    public String updateUserEmail(Map<String, String> json) {
        Student student = studentRepository.findStudentByEmail(json.get("oldEmail")).get();
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            if(!studentRepository.findStudentByEmail(json.get("newEmail")).isPresent()){
                student.setEmail(json.get("newEmail"));
            }else{
                return "user cannot be updated, email is taken";
            }
            return "user updated, email changed";
        }else{
            return "no user to update";
        }
    }


    public String deleteUserById(Long id) {
        if(studentRepository.findById(id).isPresent()){
            studentRepository.deleteById(id);
            return "user deleted using id";
        }else{
            return "no user to delete found";
        }
    }
}
