package com.example.ToDoApp.service;

import com.example.ToDoApp.model.Home;
import com.example.ToDoApp.repository.HomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    HomeRepo homeRepo;

    public List<Home> allTasksService() {
        return homeRepo.findAll();
    }

    public void postTasksService(String task,String dueDate) {
        Home h = new Home(task,dueDate);
        homeRepo.save(h);
    }

    public void deleteTaskService(int id) {
        homeRepo.deleteById(id);
    }

    public void updateTaskService(int id, String task, String dueDate) {
        Home h = homeRepo.findById(id).orElse(null);
        if(h != null){
            h.setTask(task);
            h.setDueDate(dueDate);
            homeRepo.save(h);
        }
    }
}
