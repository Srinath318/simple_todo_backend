package com.example.ToDoApp.repository;

import com.example.ToDoApp.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepo extends JpaRepository<Home,Integer> {
}
