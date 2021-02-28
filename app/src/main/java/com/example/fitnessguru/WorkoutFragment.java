package com.example.fitnessguru;

import android.os.Bundle;
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

public class WorkoutFragment extends Fragment {
    private TextView workoutViewResults;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_workout, container, false);
        workoutViewResults = (TextView) v.findViewById(R.id.Workout_text);

        String jsonString = loadJSONFromAsset();
        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(jsonString);
            JSONArray jsonArray = obj.getJSONArray("Workouts");

            StringBuilder output = new StringBuilder();
            // goes through all json objects and adds exercise to string "output"
            for(int i = 0; i<jsonArray.length(); i++)
            {
                JSONObject exercise = jsonArray.getJSONObject(i);
                String exerciseName = exercise.getString("Exercise");
                output.append(exerciseName + "\n");
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







