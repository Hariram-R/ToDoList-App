package com.example.android.todolist;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Hari on 10/04/2018.
 */

public class TaskModel extends RealmObject {

    @PrimaryKey
    String task;

    String courseName;

    boolean isDone;

    public TaskModel() {
        task = "";
        courseName = "";
        isDone = false;
    }

    public TaskModel(String task, String courseName, boolean isDone) {
        this.task = task;
        this.courseName = courseName;
        this.isDone = isDone;
    }

    public String getCourseName() {

        return courseName;

    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
