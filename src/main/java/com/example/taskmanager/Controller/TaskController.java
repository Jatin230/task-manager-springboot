package com.example.taskmanager.Controller;
import com.example.taskmanager.Controller.TaskController;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;


import java.util.*;
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable String status){
        return taskService.getTaskByStatus(status);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String keyword){
        return  taskService.searchTasks(keyword);
    }
}
