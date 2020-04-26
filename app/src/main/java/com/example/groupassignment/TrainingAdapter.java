package com.example.groupassignment;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {
    private Workout mParentActivity;
    private ArrayList<Training> mTrainings;
    private boolean mTwoPane;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Training training = (Training) v.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(DetailFragment.ARG_ITEM_ID, training.getName());
                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, fragment).commit();
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, Workout2.class);
                intent.putExtra(DetailFragment.ARG_ITEM_ID, training.getName());
                context.startActivity(intent);
            }
        }
    };

    public TrainingAdapter(Workout parent, ArrayList<Training> trainings, boolean twoPane) {
        mParentActivity = parent;
        mTrainings = trainings;
        mTwoPane = twoPane;
    }

    //Providing a reference to the views for each data item, providing access to the main element (category name) in a view holder
    public static class TrainingViewHolder extends RecyclerView.ViewHolder  {
        public TextView name;

        public TrainingViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.tvCommentName);

        }
    }

    @Override
    public TrainingAdapter.TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_list_row, parent, false);
        return new TrainingViewHolder(v);
    }

    //Replacing the contents of the view invoked by the layout manager
    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {
        Training training = mTrainings.get(position);
        holder.name.setText(training.getName());

        holder.itemView.setTag(training);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    //Returning the size of dataset
    @Override
    public int getItemCount() {
        return mTrainings.size();
    }

}
