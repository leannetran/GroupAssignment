package com.example.groupassignment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;



public class DetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private Training mTraining;

    public DetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments().containsKey(ARG_ITEM_ID)) {
            mTraining = Training.getTraining(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle(mTraining.getName());
        }
    }

    //Inflate the UI for the fragment from fragment_detail layout resource to return our view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);


        //Initialised fragment UI elements by finding them in fragment layout, and then displayed details of the selected restaurant (for Comment (optional) I wanted it only in the detail fragment, so I added it here)
        if(mTraining != null) {
            NumberFormat formatter = NumberFormat.getInstance();
            ((TextView) rootView.findViewById(R.id.tvCommentName)).setText('"' + mTraining.getComment() + '"');
        }
        return rootView;
    }
}

