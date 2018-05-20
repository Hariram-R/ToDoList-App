package com.example.android.todolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by Hp on 4/10/2018.
 */

public class TaskViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {

    CheckBox isdone;
    TextView Taskname;

    TaskModel Tm;

    public TaskViewHolder(View itemView) {
        super(itemView);

        isdone = itemView.findViewById(R.id.TaskCheckBox);
        Taskname = itemView.findViewById(R.id.TaskName);

        isdone.setOnCheckedChangeListener(this);
    }

    void populateTask(TaskModel T)
    {
        this.Tm = T;

        Taskname.setText(Tm.getTask());
        isdone.setChecked(Tm.isDone());
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.isChecked())
        {
            Tm.setDone(true);
        }
    }
}
