package com.example.minitestmodule4.service;

import com.example.minitestmodule4.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();

    public Page<Student> findAll(Pageable pageable);

    public void save(Student student);

    public void delete(long id);

    public Student findById(long id);

    public List<Student> findByName(String name);
}
