package com.example.dmitriyk_project1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dmitriyk_project1.Models.Task;
import com.example.dmitriyk_project1.R;

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
        private TextView tvData;
        private CheckBox checkBox;
        private TextView progress;
        public TodoHolder(@NonNull View itemView) {
            super(itemView);
            tvData = itemView.findViewById(R.id.tvDescr);
            checkBox = itemView.findViewById(R.id.cbBox);
            progress = itemView.findViewById(R.id.tvPrice);
        }
        public void bind(int position){
            Task t = tasks.get(position);
            tvData.setText(t.TextTask);
            progress.setText(t.complete + "/" + t.total );
            if(t.complete == t.total)
                checkBox.setChecked(true);
            else{
                checkBox.setChecked(false);
            }

        }
    }
    public interface OnStateClickListener{
        void OnClick(Task task);
    }

}
