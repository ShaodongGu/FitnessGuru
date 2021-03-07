package com.example.fitnessguru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        Button finish = v.findViewById(R.id.finish_button);
        ProgressBar p1 = v.findViewById(R.id.CaroliesProgressBar);
        ProgressBar p2 = v.findViewById(R.id.ExerciseMinsProgressBar);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (p1.getProgress() < 100) {
                    p1.incrementProgressBy(10);
                    p2.incrementProgressBy(10);
                }
            }
        });

        return v;
    }
}
