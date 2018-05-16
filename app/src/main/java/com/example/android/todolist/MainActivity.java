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
public class MainActivity extends AppCompatActivity {

    RecyclerView crv;
    CourseModel C[];
    ArrayList<CourseModel> Cl;
    Realm db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cl = new ArrayList<>();
        /*TODO: Get course names on long click of button*/
        CourseModel cm = new CourseModel();
        cm.setCourseName("Mathematics 2 MATH F112");
        CourseModel cm2 = new CourseModel();
        cm2.setCourseName("Mech oscillations and waves PHY F111");
        CourseModel cm3 = new CourseModel();
        cm3.setCourseName("Electrical sciences eee f111");
        CourseModel cm4 = new CourseModel();
        cm4.setCourseName("Thermodynamics bits f111");
        CourseModel cm5 = new CourseModel();
        cm5.setCourseName("computer programming cs f111");
        CourseModel cm6 = new CourseModel();
        cm6.setCourseName("workshop practice me f110");
        CourseModel cm7 = new CourseModel();
        cm7.setCourseName("Bio laboratory bio f110");
        Cl.add(cm);
        Cl.add(cm2);
        Cl.add(cm3);
        Cl.add(cm4);
        Cl.add(cm5);
        Cl.add(cm6);
        Cl.add(cm7);


       /* Realm.init(this);
        db = Realm.getDefaultInstance();*/


        crv = findViewById(R.id.CourseListRV);
        crv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        crv.setHasFixedSize(true);
        /*C = new CourseModel[8];

        //db.beginTransaction();

        C[0]= new CourseModel("Mathematics 2 MATH F112");
        C[1]= new CourseModel("Mech oscillations and waves PHY F111");
        C[2]= new CourseModel("Electrical sciences eee f111");
        C[3]= new CourseModel("Thermodynamics bits f111");
        C[4]= new CourseModel("computer programming cs f111");
        C[5]= new CourseModel("technical report writing bits f112");
        C[6]= new CourseModel("workshop practice me f110");
        C[7]= new CourseModel("bio laboratory bio f110");*/
        //db.commitTransaction();
        //db.close();

        CourseAdapter A = new CourseAdapter(Cl);
        crv.setAdapter(A);




    }



}
