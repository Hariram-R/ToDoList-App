package com.example.android.todolist;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Hp on 4/9/2018.
 */

public class CourseModel extends RealmObject {

    @PrimaryKey
    String courseName;

    public CourseModel() {
        courseName="";
    }

    public String getCourseName() {

        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
