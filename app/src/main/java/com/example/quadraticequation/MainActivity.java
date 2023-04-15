package com.example.quadraticequation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText a, b, c;
    Button random;
    public Intent si;
    Random rnd;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rnd = new Random();

        a = findViewById(R.id.coefficient_a);
        b = findViewById(R.id.coefficient_b);
        c = findViewById(R.id.coefficient_c);

        random = findViewById(R.id.random);

        if (!a.getText().toString().equals("") && !b.getText().toString().equals("") && !c.getText().toString().equals("")){
            si = new Intent(this, Solution.class);
            si.putExtra("a", String.valueOf(a));
            si.putExtra("b", String.valueOf(b));
            si.putExtra("c", String.valueOf(c));
            startActivity(si);
        }
    }

    public void random_pressed(View view) {
        si = new Intent(this, Solution.class);
        si.putExtra("a", String.valueOf(rnd.nextInt(10) + 1));
        si.putExtra("b", String.valueOf(rnd.nextInt(10) + 1));
        si.putExtra("c", String.valueOf(rnd.nextInt(10) + 1));
        startActivity(si);
    }

    public void calculate_pressed(View view) {
        if (!a.getText().toString().equals("") && !b.getText().toString().equals("") && !c.getText().toString().equals("")){
            si = new Intent(this, Solution.class);
            si.putExtra("a", a.getText().toString());
            si.putExtra("b", b.getText().toString());
            si.putExtra("c", c.getText().toString());
            startActivity(si);
        }
        else{
            Toast.makeText(this, "fill all the fields", Toast.LENGTH_LONG).show();
        }
    }
}