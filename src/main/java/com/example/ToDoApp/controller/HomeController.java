package com.example.ToDoApp.controller;

import com.example.ToDoApp.model.Home;
import com.example.ToDoApp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/alltasks")
    public List<Home> allTasks(){
        return homeService.allTasksService();
    }

    @PostMapping("/posttasks")
    public String postTasks(@RequestParam("task") String task,
                            @RequestParam("dueDate") String dueDate){
        homeService.postTasksService(task,dueDate);
        return "Task added successfully";
    }

    @DeleteMapping("/deletetask/{id}")
    public String deleteTask(@PathVariable int id){
        homeService.deleteTaskService(id);
        return "Deleted";
    }

    @PutMapping("/updatetask/{id}")
    public String updateTask(@PathVariable int id,
                             @RequestParam("task") String task,
                             @RequestParam("dueDate") String dueDate){
        homeService.updateTaskService(id,task,dueDate);
        return "Updated";
    }
}

