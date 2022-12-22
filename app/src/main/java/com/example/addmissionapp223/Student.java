package com.example.addmissionapp223;

/**
 * Author  : Mohit
 * Project : AddmissionApp223
 * Date    : 1:30 PM
 **/

public class Student {
    int id;
    String name;
    String regNo;
    String state;
    int markPhysics;
    int markChemistry;
    int markMath;

    public Student(int id, String name, String regNo, String state, int markPhysics, int markChemistry, int markMath) {
        this.id = id;
        this.name = name;
        this.regNo = regNo;
        this.state = state;
        this.markPhysics = markPhysics;
        this.markChemistry = markChemistry;
        this.markMath = markMath;
    }

    public Student(String name, String regNo, String state, int markPhysics, int markChemistry, int markMath) {
        this.name = name;
        this.regNo = regNo;
        this.state = state;
        this.markPhysics = markPhysics;
        this.markChemistry = markChemistry;
        this.markMath = markMath;
    }

    public Student() {
    }
}
