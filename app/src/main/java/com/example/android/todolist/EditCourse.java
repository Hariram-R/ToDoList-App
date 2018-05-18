package com.example.android.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

import io.realm.Realm;

public class EditCourse extends AppCompatActivity implements View.OnClickListener{

    String transName;
    EditText Et;
    Button tickButton;
    Button deleteButton;

    private CourseModel newCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);

        Et = findViewById(R.id.EditNameField);
        tickButton = findViewById(R.id.Tick_Button);
        deleteButton = findViewById(R.id.DeleteButton);

        tickButton.setOnClickListener(this);
        newCourse = new CourseModel();

        if(getIntent().getAction().equals("EditCourse"))
        {
            transName =getIntent().getExtras().getString("CourseName");
            Et.setText(transName);
        }
        else
            transName = "";

        /*tickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.insertOrUpdate(newCourse);
                realm.commitTransaction();
                realm.close();


                Intent backIntent = new Intent(view.getContext(),MainActivity.class);
                startActivity(backIntent);

            }
        });*/
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.Tick_Button)
        {
            String newCourseName = Et.getText().toString();
            newCourse.setCourseName(newCourseName);
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            realm.insertOrUpdate(newCourse);
            realm.commitTransaction();
            realm.close();
        }

        finish();
    }
}
