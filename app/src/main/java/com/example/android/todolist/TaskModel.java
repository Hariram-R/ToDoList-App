package com.example.android.todolist;

/**
 * Created by Hp on 4/10/2018.
 */

public class TaskModel {
    String task;
    boolean isDone;

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
