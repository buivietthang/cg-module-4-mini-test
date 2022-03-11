package com.example.minitestmodule4.repository;

import com.example.minitestmodule4.model.ClassRoom;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClassRoomRepo extends PagingAndSortingRepository<ClassRoom, Long> {
}
