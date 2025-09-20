package com.example.ToDoApp;

import com.example.ToDoApp.entity.ToDo;
import com.example.ToDoApp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication implements CommandLineRunner {

	@Autowired
	private ToDoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Save a test Todo
		todoRepository.save(new ToDo("Test task", false));
		System.out.println("Todo saved!");
	}
}
