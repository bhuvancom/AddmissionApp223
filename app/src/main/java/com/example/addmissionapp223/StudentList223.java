package com.example.addmissionapp223;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class StudentList223 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list223);
        RecyclerView rv = findViewById(R.id.rv_students);

        DiffUtil.ItemCallback<Student> itemCallback = new DiffUtil.ItemCallback<Student>() {

            @Override
            public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem == newItem;
            }
        };

        StudentListAdapter223 studentListAdapter223 = new StudentListAdapter223(itemCallback);
        MyAppDB myAppDB = new MyAppDB(this);
        List<Student> student = myAppDB.get60Student();
        studentListAdapter223.submitList(student);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(studentListAdapter223);

    }
}