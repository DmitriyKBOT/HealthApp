package com.example.dmitriyk_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.example.dmitriyk_project1.databinding.ActivityTodolistEighteenBinding;

import java.util.ArrayList;

public class TodolistEighteen extends AppCompatActivity {

    private ActivityTodolistEighteenBinding binding;
    private TodolistAdapter adapter;
    private ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTodolistEighteenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new TodolistAdapter(this, tasks, new TodolistAdapter.OnStateClickListener() {
            @Override
            public void OnClick(Task task) {

            }
        });

        binding.listdo.setLayoutManager(new LinearLayoutManager(this));
        binding.listdo.setAdapter(adapter);


    }
}