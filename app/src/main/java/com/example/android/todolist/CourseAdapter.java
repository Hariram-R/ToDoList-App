package com.example.android.todolist;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hp on 4/9/2018.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {

    CourseModel C[];
    ArrayList<CourseModel> Cl;


    public CourseAdapter(CourseModel[] c) {
        C = c;
    }

    public CourseAdapter(ArrayList<CourseModel> cl) {
        Cl = cl;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.item_course,null);
        CourseViewHolder C = new CourseViewHolder(view);
        return C;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, final int position) {
        holder.button.setText(Cl.get(position).getCourseName());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),TasksActivity.class);
                intent.putExtra("CourseName",Cl.get(position).getCourseName());

                //ArrayList<TaskModel> TaskList = new ArrayList<>(0);

                /*for(int i = 1;i<=10;i++)
                {
                    TaskModel t1 = new TaskModel();
                    t1.setTask("Study Chapter "+i);
                    t1.setDone(false);
                    TaskList.add(t1);
                    //Log.e("hi",TaskList.get(i-1).getTask());
                }*/

               // intent.putExtra("TaskListArrayList",TaskList);


                view.getContext().startActivity(intent);
            }


        });

        holder.button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(view.getContext(),EditCourse.class);
                intent.putExtra("CourseName",Cl.get(position).getCourseName());
                //intent.putExtra("CourseObject",Cl.get(position));
                view.getContext().startActivity(intent);
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return Cl.size();
    }
}
