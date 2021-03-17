package com.christian.modelonovo.services.impl;

import com.christian.modelonovo.domain.StudentDomain;
import com.christian.modelonovo.exceptions.SyntaxErrorException;
import com.christian.modelonovo.interfaces.json.StudentJson;
import com.christian.modelonovo.repository.StudentRepository;
import com.christian.modelonovo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDomain createStudent(StudentJson studentJson) {

        String[] emailSplit = studentJson.getEmail().split("@");
        String studentEmail = emailSplit[1];

        var validEmail = studentEmail.equalsIgnoreCase("gmail.com") || studentEmail.equalsIgnoreCase("yahoo.com");

        if (!validEmail) {
            throw new SyntaxErrorException();

        }

        var studentDomain = StudentDomain.fromStudentJson(studentJson);
        return studentRepository.save(studentDomain);

    }

    @Override
    public List<StudentDomain> getAllStudent() {
        return studentRepository.findAll();
    }

}
