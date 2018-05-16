package com.example.android.todolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Hp on 4/10/2018.
 */

public class TaskViewHolder extends RecyclerView.ViewHolder {

    CheckBox isdone;
    TextView Taskname;

    public TaskViewHolder(View itemView) {
        super(itemView);

        isdone = itemView.findViewById(R.id.TaskCheckBox);
        Taskname = itemView.findViewById(R.id.TaskName);
    }
}
