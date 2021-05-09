package com.example.calculatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    TextView outputBox;
    String equation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.botNav);
        bottomNavigationView.setSelectedItemId(R.id.calculator);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.calculator:
                       // startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        return true;

                    // other cases
                    case R.id.SimulEquations:
                        startActivity(new Intent(getApplicationContext(), simulEquationsCalc.class));
                        return true;

                }
                return false;
            }
        });



        outputBox = findViewById(R.id.outputBar);
        outputBox.setText(equation);
    }

    public void moveActivity(View view){
        Intent goToSimul = new Intent(getApplicationContext(), simulEquationsCalc.class);
        startActivity(goToSimul);
    }

    // -------------- Methods for adding user inputs to screen -------------------------------------------------------------------------------------

    public void clearBtn(View view){
        outputBox.setText("");
        equation = "";
    }

    public void oneBtn(View view){
        String editor = equation + "1";
        outputBox.setText(editor);
        equation = editor;
    }

    public void twoBtn(View view){
        String editor = equation + "2";
        outputBox.setText(editor);
        equation = editor;
    }

    public void threeBtn(View view){
        String editor = equation + "3";
        outputBox.setText(editor);
        equation = editor;
    }

    public void fourBtn(View view){
        String editor = equation + "4";
        outputBox.setText(editor);
        equation = editor;
    }

    public void fiveBtn(View view){
        String editor = equation + "5";
        outputBox.setText(editor);
        equation = editor;
    }

    public void sixBtn(View view){
        String editor = equation + "6";
        outputBox.setText(editor);
        equation = editor;
    }

    public void sevenBtn(View view){
        String editor = equation + "7";
        outputBox.setText(editor);
        equation = editor;
    }

    public void eightBtn(View view){
        String editor = equation + "8";
        outputBox.setText(editor);
        equation = editor;
    }

    public void nineBtn(View view){
        String editor = equation + "9";
        outputBox.setText(editor);
        equation = editor;
    }

    public void zeroBtn(View view){
        String editor = equation + "0";
        outputBox.setText(editor);
        equation = editor;
    }

    public void plusBtn(View view){
        String editor = equation + "+";
        outputBox.setText(editor);
        equation = editor;
    }

    public void minusBtn(View view){
        String editor = equation + "-";
        outputBox.setText(editor);
        equation = editor;
    }

    public void multiplyBtn(View view){
        String editor = equation + "*";
        outputBox.setText(editor);
        equation = editor;
    }

    public void divideBtn(View view){
        String editor = equation + "/";
        outputBox.setText(editor);
        equation = editor;
    }

    public void lBracketBtn(View view){
        String editor = equation + "(";
        outputBox.setText(editor);
        equation = editor;
    }

    public void rBracketBtn(View view){
        String editor = equation + ")";
        outputBox.setText(editor);
        equation = editor;
    }

    public void decimalBtn(View view){
        String editor = equation + ".";
        outputBox.setText(editor);
        equation = editor;
    }

    public void equalsBtn(View view){

    Expression exp = new Expression(equation);
    String result = String.valueOf(exp.calculate());
    outputBox.setText(result);

    }
}
