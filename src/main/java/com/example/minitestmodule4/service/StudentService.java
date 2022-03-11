package com.example.minitestmodule4.service;

import com.example.minitestmodule4.model.Student;
import com.example.minitestmodule4.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepo.findAll(pageable);
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void delete(long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student findById(long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepo.findByName(name);
    }
}
