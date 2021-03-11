package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;

public class simulEquationsCalc extends AppCompatActivity {

    int x;
    int y;

    int a = 3;
    int b = 3;
    int j = 1;
    int k = 7;
    int r = 18;
    int r2 = 30;

    int neg1 = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simul_equations_calc);

        // ----- Make equations have same X coefficient
        int aj = a*j;
        int jb = j*b;
        int ak = a*k;
        int ar2 = a*r2;

        // ---- Multiply one equation by -1

        int naj = aj * neg1;
        int njb = jb * neg1;
        int nr = r*neg1;
        int eqResult = ar2 - r;

        int rY = ak - jb;

        int y = eqResult / rY;

        int x = r2 - k*y;

        System.out.println("This is simul value for Y: " + y);

        System.out.println("This is simul value for X: " + x);






    }
}
