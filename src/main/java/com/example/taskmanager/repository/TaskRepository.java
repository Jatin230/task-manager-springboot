package com.example.taskmanager.repository;
import com.example.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String Status);
    List<Task> findByTitleContainingIgnoreCase(String keyword);
}
