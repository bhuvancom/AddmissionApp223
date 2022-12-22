package com.example.addmissionapp223;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Author  : Mohit
 * Project : AddmissionApp223
 * Date    : 1:24 PM
 **/

public class MyAppDB extends SQLiteOpenHelper {
    public MyAppDB(Context context) {
        super(context, "mydb.db", null, 1);
    }

    public List<Student> getBySql(String sql) {
        List<Student> all = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(sql, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            int id = res.getInt(0);
            String regNo = res.getString(1);
            String name = res.getString(2);
            int physicM = res.getInt(3);
            int chemistM = res.getInt(4);
            int mathM = res.getInt(5);
            String state = res.getString(6);
            Student s = new Student(id, name, regNo, state, physicM, chemistM, mathM);
            all.add(s);
            res.moveToNext();
        }

        res.close();
        return all;
    }

    public List<Student> getAllStudent() {
        return getBySql("SELECT * from students");
    }

    public List<Student> get60Student() {
        return getBySql("SELECT * from students where ((physics_m + chemist_m + math_m) / 3) > 60");
    }

    public void addStudent(Student s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", s.name);
        contentValues.put("reg_no", s.regNo);
        contentValues.put("physics_m", s.markPhysics);
        contentValues.put("chemist_m", s.markChemistry);
        contentValues.put("math_m", s.markMath);
        contentValues.put("state", s.state);
        db.insert("students", null, contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table students (" +
                        "id integer primary key, " +
                        "reg_no text, " +
                        "name text, " +
                        "physics_m integer, " +
                        "chemist_m integer, " +
                        "math_m integer, " +
                        "state text " +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }
}
