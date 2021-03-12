package com.example.fitnessguru;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Collections;

public class WorkoutFragment extends Fragment {
    private TextView workoutViewResults;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int repeat_times = 3;

        View v = inflater.inflate(R.layout.fragment_workout, container, false);
        workoutViewResults = (TextView) v.findViewById(R.id.Workout_text);

        workoutViewResults.setMovementMethod(new ScrollingMovementMethod());
        String workoutPageDescription = "Repeat each workout " + repeat_times + " times!";
        if (MainActivity.all_weights.size() > 5){
            repeat_times += 2;
        }

        String jsonString = loadJSONFromAsset();
        ArrayList<String> exerciseList = new ArrayList<String>(); // list of exercises
        ArrayList<String> descriptionList = new ArrayList<String>(); // list of exercises descriptions
        ArrayList<String> subExerciseList = new ArrayList<String>();

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(jsonString);
            JSONArray jsonArray = obj.getJSONArray("Workouts");

            StringBuilder output = new StringBuilder();
            output.append(workoutPageDescription + "\n\n");

            // goes through all json objects and adds exercise to string "output"
            for(int i = 0; i<jsonArray.length(); i++)
            {
                JSONObject exercise = jsonArray.getJSONObject(i);
                String exerciseName = exercise.getString("Exercise");
                String description = exercise.getString("Notes");
                exerciseList.add(exerciseName); // adds exercise to list
                descriptionList.add(description); // adds exercise description to list
                // output.append(exerciseName + "\n");
            }

            int exerciseListSize = exerciseList.size();
            Collections.shuffle(exerciseList);

            for(int i = 0; i<5; i++)
            {
                output.append(exerciseList.get(i) + ":" + "\n" + descriptionList.get(i) +"\n\n");
            }



            workoutViewResults.setText(output.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return v;
    }
    // returns jason file as string
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("Workoutsjson.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}







