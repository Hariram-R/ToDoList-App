package com.example.android.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditCourse extends AppCompatActivity {

    String transName;
    EditText Et;
    Button tickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);

        Et = findViewById(R.id.EditNameField);

        transName =getIntent().getExtras().getString("CourseName");
        Et.setText(transName);

        tickButton = findViewById(R.id.Tick_Button);

        tickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newCourse = Et.getText().toString();

            }
        });





    }
}
