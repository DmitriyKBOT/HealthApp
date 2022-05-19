package com.example.dmitriyk_project1.Models;

public class Task {
    public String TextTask;
    public int total;
    public int complete;

    public Task() {

    }

    public Task(String textTask, int total, int complete) {
        TextTask = textTask;
        this.total = total;
        this.complete = complete;
    }
}
