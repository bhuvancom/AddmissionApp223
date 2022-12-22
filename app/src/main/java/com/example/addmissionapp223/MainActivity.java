package com.example.addmissionapp223;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout reg_no_223, name_223, marks_physics_223, marks_chemistry_223, marks_maths_223;
    Spinner states_223;
    private static final String TAG = "MainActivity";
    MyAppDB myAppDB;

    String getValue223(@IdRes int id) {
        TextInputLayout layout = findViewById(id);
        return layout.getEditText().getText().toString();
    }

    int getMarks223(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            Log.d(TAG, "getMarks223: error in parse " + e.getMessage());
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAppDB = new MyAppDB(this);
        Button btnSubmit = findViewById(R.id.submit);
        states_223 = findViewById(R.id.spinner_states);
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.states));
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        states_223.setAdapter(ad);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitStudent();
            }
        });
    }

    private void submitStudent() {
        String regNo = getValue223(R.id.reg_no);
        String name = getValue223(R.id.name);
        int physicsM = getMarks223(getValue223(R.id.mark_p));
        int chemistM = getMarks223(getValue223(R.id.mark_c));
        int mathM = getMarks223(getValue223(R.id.mark_m));
        String state = states_223.getSelectedItem().toString();
        Student s = new Student(name, regNo, state, physicsM, chemistM, mathM);

        myAppDB.addStudent(s);

        startActivity(new Intent(MainActivity.this, StudentList223.class));

    }

}