package com.example.quadraticequation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Solution extends AppCompatActivity {
    public Intent gi;
    int a, b, c;
    Double solution1, solution2;
    String a1, b1, c1;
    TextView tv1, tv2;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        gi = getIntent();

        a = Integer.parseInt(gi.getStringExtra("a"));
        b = Integer.parseInt(gi.getStringExtra("b"));
        c = Integer.parseInt(gi.getStringExtra("c"));



        tv1 = findViewById(R.id.way_of_solution);
        tv2 = findViewById(R.id.solutions);


        x1_calculate(a, b, c, tv1);
        x2_calculate(a, b, c, tv1);

        solution1 = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        solution2 = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        if ((b * b) - (4 * a * c) < 0){
            tv2.setText(tv2.getText().toString() + "solution1: "+"no solution\n");
            tv2.setText(tv2.getText().toString() + "solution2: "+"no solution");

        }
        else{
            tv2.setText(tv2.getText().toString() + "solution1: "+solution1+"\n");
            tv2.setText(tv2.getText().toString() + "solution2: "+solution2);
        }
    }

    @SuppressLint("SetTextI18n")
    public static void x1_calculate(int a, int b, int c, TextView tv) {
        tv.setText(tv.getText() + "x1 = " + "(-" + b + "+" + "(sqrt(" + b + "^2 - 4*" + a + "*" + c + ")))/2*" +a+ "\n");
        tv.setText(tv.getText() + "x1 = " + "(-" + b + "+" + "(sqrt(" + (b * b) + " - " + (4 * a * c) + ")))/2*"+a+ "\n");

        int i = (b * b) - (4 * a * c);
        if (i < 0) {
            tv.setText(tv.getText() + "x1 = " + "(-" + b + "+" + "(sqrt(" + i + ")))/2*"+a+ "\n");
            tv.setText(tv.getText() + "x1 = no solution \n \n");
        } else {
            tv.setText(tv.getText() + "x1 = " + "(-" + b + "+" + "(sqrt(" + i + ")))/2*"+a+ "\n");
            tv.setText(tv.getText() + "x1 = " + "(-" + b + "+" + Math.sqrt(i) + ")/2*"+a + "\n");
            tv.setText(tv.getText() + "x1 = " + (-b + Math.sqrt(i)) / (2 * a) + "\n" + "\n");
        }
    }

    @SuppressLint("SetTextI18n")
    public static void x2_calculate(int a, int b, int c, TextView tv){
        tv.setText(tv.getText() + "x2 = " + "(-"+b+"-" + "(sqrt(" + b+"^2 - 4*"+a+"*"+c+")))/2*"+a+"\n");
        tv.setText(tv.getText() + "x2 = " + "(-"+b+"-" + "(sqrt(" + (b * b) +" - " + (4 * a * c)+")))/2*"+a+"\n");

        int i = (b * b) - (4 * a * c);
        if (i < 0){
            tv.setText(tv.getText() + "x2 = " + "(-"+b+"-" + "(sqrt(" + i +")))/2*"+a+"\n");
            tv.setText(tv.getText() + "x2 = no solution");
        }
        else{
            tv.setText(tv.getText() + "x2 = " + "(-"+b+"-" + "(sqrt(" + i +")))/2*"+a+"\n");
            tv.setText(tv.getText() + "x2 = " + "(-"+b+"-" + Math.sqrt(i)+")/2*"+a+"\n");
            tv.setText(tv.getText() + "x2 = " + (-b - Math.sqrt(i)) / (2 * a)+"\n" + "\n");
        }
    }

    public void back_pressed(View view) {
        Intent si = new Intent(this, MainActivity.class);
        startActivity(si);
    }
}