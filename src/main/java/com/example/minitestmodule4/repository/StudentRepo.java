package com.example.minitestmodule4.repository;

import com.example.minitestmodule4.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends PagingAndSortingRepository<Student, Long> {
    @Query(value = "select s from Student s where s.name like concat('%' ,:name, '%')")
    List<Student> findByName(@Param("name") String name);
}
