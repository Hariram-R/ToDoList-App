package com.example.android.todolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hp on 4/9/2018.
 */

public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    Button button;

    @Override
    public void onClick(View view) {
        int pos = getLayoutPosition();
        switch (pos)
        {
            case 0: break;
            case 1: break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 7: break;
        }
    }

    public CourseViewHolder(View itemView) {
        super(itemView);
        button=itemView.findViewById(R.id.course1);

    }
}
