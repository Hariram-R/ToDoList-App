package com.example.android.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;


/**
 * TODO: Task Disappears on clicking checkbox
 * TODO: Start Realm by using course names first.
 * */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView crv;
    //ArrayList<CourseModel> Cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Cl = new ArrayList<>();

        crv = findViewById(R.id.CourseListRV);
        crv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //crv.setHasFixedSize(false);

        final Button addNewCourse = findViewById(R.id.AddCourseButton);
        addNewCourse.setOnClickListener(this);

        CourseAdapter A = new CourseAdapter();
        crv.setAdapter(A);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,EditCourse.class);
        intent.setAction("CreateCourse");
        //intent.putExtra("CourseName","");
        //intent.putExtra("CourseObject",Cl.get(position));
        startActivity(intent);
    }
}
