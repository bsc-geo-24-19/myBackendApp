package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentCornfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
         Student Shad =   new Student(

                    5L,
                    "Shad",
                    "shad@gmail.com",
                    LocalDate.of(2019, Month.MARCH, 5)
            );

            Student perfect =  new Student(

                    2L,
                    "Perfect",
                    "perfect@gmail.com",
                    LocalDate.of(2016, Month.MARCH, 3)
            );
            Student Sharom = new Student(

                    3L,
                    "Sharom",
                    "sharom@gmail.com",
                    LocalDate.of(2016, Month.MARCH, 4)
            );
            repository.saveAll(List.of(Shad, perfect, Sharom));
        };

    }

}
