package com.example.fitnessguru;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        Button finish = v.findViewById(R.id.finish_button);
        ProgressBar p1 = v.findViewById(R.id.CaroliesProgressBar);
        ProgressBar p2 = v.findViewById(R.id.ExerciseMinsProgressBar);
        TextView c1 = v.findViewById(R.id.CaroliesNumber_text);
        TextView c2 = v.findViewById(R.id.ExerciseMinsNumber_text);

        SharedPreferences sharedpreferenceslogin = getActivity().getSharedPreferences(
                "FITNESSGURU", MODE_PRIVATE);
        String sweight_input = sharedpreferenceslogin.getString("weight", "");
        int total_min = 90;
        try{
            total_min = Integer.parseInt(sharedpreferenceslogin.getString("time", ""));
        }
        catch (NumberFormatException e) {

        }

        //to display the current weight on the home app.
        Toast.makeText(getActivity().getApplicationContext(),""+sweight_input,Toast.LENGTH_LONG).show();
        int finalTotal_min = total_min;
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (p1.getProgress() < 100) {
                    p1.incrementProgressBy(20);
                    p2.incrementProgressBy(15);
                    c1.setText("2500");
                    c2.setText("30");
                }
            }
        });
        return v;
    }
}
