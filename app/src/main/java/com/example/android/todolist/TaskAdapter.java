package com.example.android.todolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Hp on 4/10/2018.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder>
{

    Context context;
    ArrayList<TaskModel> TaskList;
    String course;
    Realm realm;


    public TaskAdapter(Context context, String course) {
        this.context = context;
        this.course = course;

        this.TaskList = new ArrayList<>();
        realm = Realm.getDefaultInstance();
        loadTaskData();

    }

    void loadTaskData()
    {
        //TODO : Delete task if completed

        RealmResults<TaskModel> taskModelRealmResults = realm.where(TaskModel.class).equalTo("courseName",course).findAll();

        int i = 0;
        while (i<taskModelRealmResults.size())
        {
            TaskList.add(taskModelRealmResults.get(i));
            i++;
        }
        notifyDataSetChanged();

    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
        TaskViewHolder Tvh = new TaskViewHolder(view);
        return Tvh;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.populateTask(TaskList.get(position));
    }

    @Override
    public int getItemCount() {
        return TaskList.size();
    }

    public void addNewTask(String task)
    {
        boolean flag = false;

        for(int i = 0;i<TaskList.size();i++)
        {
            if(task.equals(TaskList.get(i).getTask()))
            {
                Toast.makeText(context,"Task already exists!",Toast.LENGTH_SHORT).show();
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            TaskModel newTaskObj = new TaskModel();
            newTaskObj.setTask(task);
            newTaskObj.setDone(false);
            newTaskObj.setCourseName(course);

            TaskList.add(newTaskObj);
            notifyDataSetChanged();

            realm.beginTransaction();
            realm.insert(newTaskObj);
            realm.commitTransaction();
        }

    }


    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        realm.close();
    }
}
