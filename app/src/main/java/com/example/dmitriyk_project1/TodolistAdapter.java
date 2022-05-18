package com.example.dmitriyk_project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodolistAdapter extends RecyclerView.Adapter<TodolistAdapter.TodoHolder> {

    private Context context;
    private ArrayList<Task>tasks;
    private OnStateClickListener listener;

    public TodolistAdapter(Context context, ArrayList<Task> tasks, OnStateClickListener listener) {
        this.context = context;
        this.tasks = tasks;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TodoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TodoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_to_do, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TodoHolder holder, int position) {
        holder.bind(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(tasks.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TodoHolder    extends RecyclerView.ViewHolder{
        private TextView txtM;
        public TodoHolder(@NonNull View itemView) {
            super(itemView);
            txtM = itemView.findViewById(R.id.txtV4);
        }
        public void bind(int position){
            txtM.setText(tasks.get(position).TextTask);

        }
    }
    public interface OnStateClickListener{
        void OnClick(Task task);
    }

}
