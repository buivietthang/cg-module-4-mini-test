package com.example.minitestmodule4.service;

import com.example.minitestmodule4.model.ClassRoom;
import com.example.minitestmodule4.repository.ClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {
    @Autowired
    ClassRoomRepo classRoomRepo;

    @Override
    public List<ClassRoom> findAll() {
        return (List<ClassRoom>) classRoomRepo.findAll();
    }
}
