package com.example.taskmanager.service;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class TaskService {
    private final TaskRepository repository;
    public TaskService(TaskRepository repository){
        this.repository = repository;
    }
    public Task createTask(Task task){
        return repository.save(task);
    }
    public List<Task> getAllTasks(){
        return repository.findAll();
    }
    public List<Task> getTaskByStatus(String status){
        return repository.findByStatus(status);
    }
    public void deleteTask(Long id){
        repository.deleteById(id);
    }
    public List<Task> searchTasks(String keyword){
        return repository.findByTitleContainingIgnoreCase(keyword);
    }
}
