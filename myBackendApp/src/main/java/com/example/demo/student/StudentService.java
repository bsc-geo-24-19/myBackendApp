package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student>StudentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(StudentByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentID) {
        studentRepository.findById(studentID);
       boolean exists = studentRepository.existsById(studentID);
       if(!exists){

           throw  new IllegalStateException("Student with ID " + studentID + " Does not Exist");
       }
       studentRepository.deleteById(studentID);
    }
    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow( ()-> new IllegalStateException("Student with ID" + studentID + "Does not exist"));
        if(name != null && name.length()> 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email != null && email.length()> 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student>StudentByEmail = studentRepository.findStudentByEmail(student.getEmail());
            if(StudentByEmail.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }

    }
}
