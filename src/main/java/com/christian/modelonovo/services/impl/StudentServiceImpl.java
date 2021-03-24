package com.christian.modelonovo.services.impl;

import com.christian.modelonovo.domain.StudentDomain;
import com.christian.modelonovo.exceptions.NotFoundException;
import com.christian.modelonovo.exceptions.SyntaxErrorException;
import com.christian.modelonovo.filters.StudentFilter;
import com.christian.modelonovo.interfaces.json.StudentJson;
import com.christian.modelonovo.repository.StudentRepository;
import com.christian.modelonovo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public Page<StudentDomain> getStudent(Pageable page, String email) {
        Pageable pageAble = PageRequest.of(page.getPageNumber(), page.getPageSize());

        if (Objects.nonNull(email)) {

            StudentFilter studentFilter = StudentFilter.builder().email(email.toLowerCase()).build();
            return studentRepository.findAll(studentFilter.predicate(), pageAble);
        }
        return studentRepository.findAll(pageAble);
    }

    @Override
    public StudentDomain findById(Long Id) {

        return studentRepository.findById(Id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public void delete(Long Id) {
        var student = studentRepository.findById(Id).orElseThrow(() -> new NotFoundException());

        studentRepository.delete(student);
    }

}
