package com.example.dmitriyk_project1;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    private TextView txtVN;
    private TextView txtVDO;
    private ImageView imVA;
    private RecyclerView recyclerView;
    private TodolistAdapter adapter;
    private ArrayList<Task> tasks = new ArrayList<>();
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main);
        txtVN = findViewById(R.id.txtVN);
        txtVDO = findViewById(R.id.txtVDO);
        imVA = findViewById(R.id.imVA);
        recyclerView = findViewById(R.id.recVList);
        user = (User) getIntent().getSerializableExtra("User");
        adapter = new TodolistAdapter(this, user.tasks, new TodolistAdapter.OnStateClickListener() {
            @Override
            public void OnClick(Task task) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}