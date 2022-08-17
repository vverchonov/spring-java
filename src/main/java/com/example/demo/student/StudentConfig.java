package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student one = new Student("Slava","Verchonov","slava@gmail.com", LocalDate.of(1999, Month.NOVEMBER,04));
            Student two = new Student("Tatiana","Verchonova","tatiana@gmail.com",LocalDate.of(1980, Month.APRIL,06));
            Student three = new Student("Denis","Tsykozin","tsykozin@gmail.com",LocalDate.of(1981, Month.OCTOBER,01));
            repository.saveAll(List.of(one,two,three));
        };

    }
}
