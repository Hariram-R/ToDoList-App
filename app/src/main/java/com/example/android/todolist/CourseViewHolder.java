package com.example.android.todolist;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hp on 4/9/2018.
 */

public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    Button button;
    CourseModel Cm;

    public CourseViewHolder(View itemView) {
        super(itemView);
        this.button=itemView.findViewById(R.id.course1);

        button.setOnClickListener(this);
        button.setOnLongClickListener(this);
    }

    void populateCourseButton(CourseModel Cm1)
    {
        this.Cm = Cm1;
        button.setText(Cm1.getCourseName());
    }

    @Override
    public void onClick(View view) {
            Intent intent = new Intent(view.getContext(),TasksActivity.class);
            intent.putExtra("CourseName",Cm.getCourseName());
            intent.setAction("ViewTasks");
            view.getContext().startActivity(intent);

    }


    @Override
    public boolean onLongClick(View view) {
        Intent intent = new Intent(view.getContext(),EditCourse.class);
        intent.putExtra("CourseName",Cm.getCourseName());
        intent.setAction("EditCourse");
        view.getContext().startActivity(intent);
        return true;
    }
}
