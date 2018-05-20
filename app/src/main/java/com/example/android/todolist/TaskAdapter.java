package com.example.android.todolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Hp on 4/10/2018.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> implements RealmChangeListener<RealmResults<TaskModel>>{

    ArrayList<TaskModel> TaskList;
    Context context;
    private final Realm realm;

    String course;

    public TaskAdapter(String course)
    {
        realm = Realm.getDefaultInstance();
        this.course = course;

        TaskList = new ArrayList<>();
        loadTaskData();

    }

    void loadTaskData()
    {
        RealmQuery<TaskModel> taskModelRealmQuery = realm.where(TaskModel.class);
        RealmResults<TaskModel> taskModelRealmResults = taskModelRealmQuery.equalTo("courseName",course).findAll();

        taskModelRealmResults.addChangeListener(this);


        for(TaskModel iTM : taskModelRealmResults)
        {
            TaskList.add(realm.copyFromRealm(iTM));
        }

        notifyDataSetChanged();

    }


    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.item_task,parent,false);

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

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        realm.close();
    }

    @Override
    public void onChange(RealmResults<TaskModel> taskModels) {
        Realm realm = Realm.getDefaultInstance();
        this.TaskList = new ArrayList<>();
        for(TaskModel iTM : taskModels)
        {
            TaskList.add(realm.copyFromRealm(iTM));
        }
        realm.close();
        notifyDataSetChanged();

    }
}
