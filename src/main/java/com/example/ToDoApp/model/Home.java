package com.example.ToDoApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Home {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String task;
        private String dueDate;

        public Home() {
        }

        public Home(String task, String dueDate) {
            this.task = task;
            this.dueDate = dueDate;
        }
}
