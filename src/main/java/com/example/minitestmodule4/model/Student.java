package com.example.minitestmodule4.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;

    @ManyToOne
    private ClassRoom classRoom;
}
