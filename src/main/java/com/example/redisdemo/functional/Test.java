package com.example.redisdemo.functional;

import com.example.redisdemo.domain.Student;
import com.example.redisdemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Test {
    @Autowired
    private StudentRepository studentRepository;

    @Scheduled(fixedDelay = 1)
    void add() {
        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);
    }

    private Student retrieve() {
        return studentRepository.findById("Eng2015001").get();
    }

    @Scheduled(fixedDelay = 1)
    void update() {
        Student retrievedStudent = retrieve();
        retrievedStudent.setName("Richard Watson");
        studentRepository.save(retrievedStudent);
    }

    @Scheduled(fixedDelay = 1)
    void delete() {
        Student student = retrieve();
        studentRepository.delete(student);
    }
}
