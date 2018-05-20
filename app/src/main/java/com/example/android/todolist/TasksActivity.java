package com.example.android.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;

public class TasksActivity extends AppCompatActivity implements View.OnClickListener{

    TextView courseTitle;
    RecyclerView TaskList;
    EditText addTask;
    Button addButton;
    String transName; //Transferred Course name from MainActivity
    TaskAdapter TA;
    TaskAdapter TA2;
    RecyclerView.Adapter adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        courseTitle = findViewById(R.id.CourseName);
        TaskList = findViewById(R.id.TaskListRV);
        TaskList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        TaskList.setHasFixedSize(false);


        addTask = findViewById(R.id.InputTask);
        addButton = findViewById(R.id.AddTaskButton);
        addButton.setOnClickListener(this);


        transName =getIntent().getExtras().getString("CourseName");
        courseTitle.setText(transName);


        TA = new TaskAdapter(transName);
        TaskList.setAdapter(TA);

       //Tasks = (ArrayList<TaskModel>) getIntent().getSerializableExtra("TaskListArrayList");



    }

    @Override
    public void onClick(View view) {
        String task = addTask.getText().toString();

        boolean flag = false;
        for(int i = 0;i<task.length();i++)
        {
            if(task.charAt(i)!=' ')
                flag = true;
        }

        if(!flag || task.equals(""))
        {
            Toast emptyWarning = Toast.makeText(getApplicationContext(),"Task cannot be Empty!",Toast.LENGTH_SHORT);
            emptyWarning.show();
        }
        else
        {
            TaskModel newTaskObj = new TaskModel();
            newTaskObj.setTask(task);
            newTaskObj.setDone(false);
            newTaskObj.setCourseName(transName);

            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            realm.insertOrUpdate(newTaskObj);
            realm.commitTransaction();

            addTask.setText("");

            TA2 = new TaskAdapter(transName);
            TaskList.setAdapter(TA2);

        }
    }
}
