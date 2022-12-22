package com.example.addmissionapp223;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author  : Mohit
 * Project : AddmissionApp223
 * Date    : 1:46 PM
 **/

public class StudentListAdapter223 extends ListAdapter<Student, StudentListAdapter223.StViewHolder> {

    protected StudentListAdapter223(@NonNull DiffUtil.ItemCallback<Student> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public StViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class StViewHolder extends RecyclerView.ViewHolder {
        TextView name, regNo, avgMark, state;

        private TextView getView(View v, @IdRes int id) {
            return v.findViewById(id);
        }

        public StViewHolder(@NonNull View itemView) {
            super(itemView);
            name = getView(itemView, R.id.name);
            regNo = getView(itemView, R.id.reg_no);
            avgMark = getView(itemView, R.id.avg_marks);
            state = getView(itemView, R.id.state);
        }

        public void bind(Student student) {
            name.setText("Name - " + student.name);
            regNo.setText("Registration no - " + student.regNo);
            int avgM = (student.markChemistry + student.markPhysics + student.markMath) / 3;
            avgMark.setText("Average - " + avgM + "%");
            state.setText("State - " + student.state);
        }
    }
}
