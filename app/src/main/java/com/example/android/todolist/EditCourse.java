package com.example.android.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

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
        deleteButton.setOnClickListener(this);
        newCourse = new CourseModel();

        if(getIntent().getAction().equals("EditCourse"))
        {
            transName =getIntent().getExtras().getString("CourseName");
            Et.setText(transName);
        }
        else
            transName = "";

    }

    @Override
    public void onClick(View view) {
        Realm realm = Realm.getDefaultInstance();
        boolean exflag = false; // For empty course logic

        if(view.getId()==R.id.Tick_Button)
        {
            final String newCourseName = Et.getText().toString();

            boolean flag = false;
            for(int i = 0;i<newCourseName.length();i++)
            {
                if(newCourseName.charAt(i)!=' ')
                    flag = true;
            }

            if(!flag || newCourseName.equals(""))
            {
                Toast emptyWarning = Toast.makeText(getApplicationContext(),"Course name cannot be Empty!",Toast.LENGTH_SHORT);
                emptyWarning.show();
            }
            else
            {
                newCourse.setCourseName(newCourseName);
                exflag = true;
            }


            if(getIntent().getAction().equals("EditCourse"))
            {
                RealmQuery<CourseModel> query = realm.where(CourseModel.class);
                final CourseModel  result = query.equalTo("courseName",transName).findFirst();

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        result.deleteFromRealm();
                        realm.insertOrUpdate(newCourse);
                        /* TODO Copy all course data  into new course!*/

                    }
                });
            }

            if(exflag)
            {
                realm.beginTransaction();
                realm.insertOrUpdate(newCourse);
                realm.commitTransaction();

            }

            realm.close();

        }
        else if (view.getId()==R.id.DeleteButton)
        {
            RealmQuery<CourseModel> query = realm.where(CourseModel.class);
            final RealmResults<CourseModel> results = query.equalTo("courseName",transName).findAll();

            RealmQuery<TaskModel> taskQuery = realm.where(TaskModel.class);
            final RealmResults<TaskModel> taskResults = taskQuery.equalTo("courseName",transName).findAll();

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    results.deleteAllFromRealm();
                    taskResults.deleteAllFromRealm();

                }
            });

            realm.close();
        }

        Intent intenttoMainActivity = new Intent(view.getContext(),MainActivity.class);
        startActivity(intenttoMainActivity);
        finish();
    }
}
