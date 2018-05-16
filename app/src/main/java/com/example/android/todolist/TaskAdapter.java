package com.example.android.todolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Hp on 4/10/2018.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    ArrayList<TaskModel> TaskList;
    Context context;

    public TaskAdapter(ArrayList<TaskModel> taskList,Context context) {
        TaskList = new ArrayList<>(taskList);
        this.context = context;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.item_task,null);

        TaskViewHolder Tvh = new TaskViewHolder(view);
        return Tvh;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.Taskname.setText(TaskList.get(position).getTask());
        holder.isdone.setChecked(TaskList.get(position).isDone());
    }

    @Override
    public int getItemCount() {
        return TaskList.size();
    }
}
