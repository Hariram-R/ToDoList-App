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

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    TextView courseTitle;
    RecyclerView TaskList;
    EditText addTask;
    Button addButton;
    String transName; //Transferred Course name from MainActivity
    TaskAdapter TA;
    RecyclerView.Adapter adapter2;

    ArrayList<TaskModel> Tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        Tasks = new ArrayList<>(0);

        /*for(int i = 1;i<=5;i++) {
            TaskModel t1 = new TaskModel();
            t1.setTask("Study Chapter " + i);
            t1.setDone(false);
            Tasks.add(t1);
            //Log.e("hi",Tasks.get(i-1).getTask());
        }*/

        courseTitle = findViewById(R.id.CourseName);
        TaskList = findViewById(R.id.TaskListRV);
        TaskList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        TaskList.setHasFixedSize(true);

        transName =getIntent().getExtras().getString("CourseName");
        courseTitle.setText(transName);


        TA = new TaskAdapter(Tasks,this);
        TaskList.setAdapter(TA);

       //Tasks = (ArrayList<TaskModel>) getIntent().getSerializableExtra("TaskListArrayList");


        addTask = findViewById(R.id.InputTask);
        addButton = findViewById(R.id.AddTaskButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = addTask.getText().toString();
                if(task.equals(""))
                    ;
                else{
                    TaskModel newTaskObj = new TaskModel();
                    newTaskObj.setTask(task);
                    newTaskObj.setDone(false);
                    Tasks.add(newTaskObj);
                    addTask.setText("");

                    adapter2 =  new TaskAdapter(Tasks,TasksActivity.this);
                    TaskList.setAdapter(adapter2);
                }


            }
        });



    }
}
