package com.example.android.todolist;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Hp on 4/21/2018.
 */

public class ToDoList extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
