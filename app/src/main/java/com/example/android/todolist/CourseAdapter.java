package com.example.android.todolist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Hari on 4/9/2018.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> implements RealmChangeListener<RealmResults<CourseModel>> {

    ArrayList<CourseModel> Cl;

    private final Realm realm;


    public CourseAdapter() {
        this.Cl = new ArrayList<>();
        realm = Realm.getDefaultInstance();
        loadCourseData();
    }

    public void  loadCourseData()
    {

        RealmQuery<CourseModel> courseModelRealmQuery = realm.where(CourseModel.class);
        RealmResults<CourseModel> courseModelRealmResults = courseModelRealmQuery.findAll();

        courseModelRealmResults.addChangeListener(this);

        this.Cl = new ArrayList<>();
        for(CourseModel iCM : courseModelRealmResults)
        {
            Cl.add(realm.copyFromRealm(iCM));
        }
        notifyDataSetChanged();

    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.item_course,parent,false);
        CourseViewHolder C = new CourseViewHolder(view);
        return C;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, final int position) {
        holder.populateCourseButton(Cl.get(position));
    }

    @Override
    public void onChange(@NonNull RealmResults<CourseModel> courseModels) {
        Realm realm = Realm.getDefaultInstance();
        this.Cl = new ArrayList<>();
        for(CourseModel iCM : courseModels)
        {
            Cl.add(realm.copyFromRealm(iCM));
        }
        realm.close();
        notifyDataSetChanged();

    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        realm.close();
    }

    @Override
    public int getItemCount() {
        return Cl.size();
    }
}
