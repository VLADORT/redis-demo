package com.example.redisdemo.domain;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@RedisHash("Student")
@Data
public class Student implements Serializable {
    public enum Gender {
        MALE, FEMALE
    }

    public Student(String id, String name, Gender gender, int grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }
    private String id;
    private String name;
    private Gender gender;
    private int grade;
}

