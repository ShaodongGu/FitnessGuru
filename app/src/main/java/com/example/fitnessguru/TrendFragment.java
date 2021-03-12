package com.example.fitnessguru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class TrendFragment extends Fragment {
    private static final String TAG = "TrendFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trend, container, false);

        GraphView graph = (GraphView) v.findViewById(R.id.graph);
        DataPoint[] all_points = new DataPoint[MainActivity.all_weights.size()];
        for(int i=0; i < MainActivity.all_weights.size(); i++){
            DataPoint a = new DataPoint(i, MainActivity.all_weights.get(i));
            all_points[i] = a;
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(all_points);
        graph.addSeries(series);

        return v;
    }
}
