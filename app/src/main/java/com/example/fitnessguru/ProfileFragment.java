package com.example.fitnessguru;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class ProfileFragment extends Fragment {

    SharedPreferences sharedpreferenceslogin;
    public static final String MyPREFERENCESLogin = "FITNESSGURU";
    public static final String GENDER = "gender";
    public static final String CALORIE = "calorie";
    public static final String TIME = "time";
    public static final String WEIGHT = "weight";
    public static final String WEIGHTLBS = "weightlbs";
    public static final String NAME = "name";
    public static final String HEIGHT = "height";
    public static final String AGE = "age";

    Spinner gender_spinner;
    EditText calorie_input, time_input, weight_input, weight_inputlbs, name_input, height_input, age_input;
    String scalorie_input, stime_input, sweight_input, sweight_inputlbs, sname_input, sheight_input, sage_input, sgender;
    Button submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        calorie_input = view.findViewById(R.id.calorie_input);
        time_input = view.findViewById(R.id.time_input);
        weight_input = view.findViewById(R.id.weight_input);
        weight_inputlbs = view.findViewById(R.id.Weight_input);
        name_input = view.findViewById(R.id.Name_input);
        height_input = view.findViewById(R.id.Height_input);
        age_input = view.findViewById(R.id.Age_input);
        gender_spinner = view.findViewById(R.id.Gender_spinner);
        submit = view.findViewById(R.id.bsubmit);


        sharedpreferenceslogin = getActivity().getSharedPreferences(
                "FITNESSGURU", MODE_PRIVATE);


        scalorie_input = sharedpreferenceslogin.getString("calorie", "");
        stime_input = sharedpreferenceslogin.getString("time", "");
        sweight_input = sharedpreferenceslogin.getString("weight", "");
        sweight_inputlbs = sharedpreferenceslogin.getString("weightlbs", "");
        sname_input = sharedpreferenceslogin.getString("name", "");
        sheight_input = sharedpreferenceslogin.getString("height", "");
        sage_input = sharedpreferenceslogin.getString("age", "");
        sgender = sharedpreferenceslogin.getString("gender", "");

        try {
            calorie_input.setText("" + scalorie_input);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        try {
            time_input.setText("" + stime_input);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        try {
            weight_input.setText("" + sweight_input);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        try {
            weight_inputlbs.setText("" + sweight_inputlbs);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        try {
            name_input.setText("" + sname_input);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        try {
            height_input.setText("" + sheight_input);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        try {
            age_input.setText("" + sage_input);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }

        try {
            if (sgender.equalsIgnoreCase("Male")) {
                gender_spinner.setSelection(0);
            } else if (sgender.equalsIgnoreCase("Female")) {
                gender_spinner.setSelection(1);
            }
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferenceslogin
                        .edit();
                editor.putString(GENDER, "" + gender_spinner.getSelectedItem().toString());
                editor.putString(CALORIE, ""+calorie_input.getText().toString());
                editor.putString(TIME, ""+time_input.getText().toString());
                editor.putString(WEIGHT, ""+weight_input.getText().toString());
                editor.putString(WEIGHTLBS, ""+weight_inputlbs.getText().toString());
                editor.putString(NAME, ""+name_input.getText().toString());
                editor.putString(HEIGHT, ""+height_input.getText().toString());
                editor.putString(AGE, ""+age_input.getText().toString());
                editor.commit();

                Toast.makeText(getActivity().getApplicationContext(),"Data has been saved",Toast.LENGTH_LONG).show();

                MainActivity.all_weights.add(Integer.parseInt(weight_inputlbs.getText().toString()));

            }
        });

        return view;
    }
}
