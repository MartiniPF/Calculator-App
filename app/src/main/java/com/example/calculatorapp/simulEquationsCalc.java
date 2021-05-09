package com.example.calculatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;

public class simulEquationsCalc extends AppCompatActivity {

    int neg1 = -1;

    EditText xInput1;
    EditText yInput1;
    EditText result1;
    EditText xInput2;
    EditText yInput2;
    EditText result2;
    TextView xResult;
    TextView yResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simul_equations_calc);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botNav);
        bottomNavigationView.setSelectedItemId(R.id.SimulEquations);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.calculator:
                         startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        return true;

                    // other cases
                    case R.id.SimulEquations:
                       // startActivity(new Intent(getApplicationContext(), simulEquationsCalc.class));
                        return true;

                }
                return false;
            }
        });

        xInput1 = findViewById(R.id.coeffX1);
        yInput1 = findViewById(R.id.coeffY1);
        result1 = findViewById(R.id.result1);
        xInput2 = findViewById(R.id.coeffX2);
        yInput2 = findViewById(R.id.coeffY2);
        result2 = findViewById(R.id.result2);

        xResult = findViewById(R.id.resultX);
        yResult = findViewById(R.id.resultY);
    }

    public void calculate(View view) {

        String xVal1 = xInput1.getText().toString();
        String xVal2 = xInput2.getText().toString();
        String yVal1 = yInput1.getText().toString();
        String yVal2 = yInput2.getText().toString();
        String r1 = result1.getText().toString();
        String r2 = result2.getText().toString();

        int coeffX1  = Integer.parseInt(xVal1);
        int coeffX2 = Integer.parseInt(xVal2);
        int coeffY1 = Integer.parseInt(yVal1);
        int coeffY2 = Integer.parseInt(yVal2);
        int res1 = Integer.parseInt(r1);
        int res2 = Integer.parseInt(r2);

        // ----- Make equations have same X coefficient

        // standardise equation 1
        int NcoeffX1 = coeffX1*coeffX2;
        int NcoeffY1 = coeffY1 * coeffX2;
        int Nres1 = res1 * coeffX2;
        System.out.println("EQ 1 is:  " + NcoeffX1 + "X + " + NcoeffY1 + "Y = " + Nres1);

        // standardise equation 2
        int NcoeffX2 = NcoeffX1;
        int NcoeffY2 = coeffY2 * coeffX1;
        int Nres2 = res2 * coeffX1;
        System.out.println("EQ 2 is:  " + NcoeffX2 + "X + " + NcoeffY2 + "Y = " + Nres2);
        // multiply equation 2 by (-1) to cancel X's

        int McoeffX2 = NcoeffX2 * neg1;
        int McoeffY2 = NcoeffY2 * neg1;
        int Mres2 = Nres2 * neg1;
        System.out.println("EQ 2 is:  " + McoeffX2 + "X + " + McoeffY2 + "Y = " + Mres2);

        // subtract Y's
        int eY = McoeffY2 + NcoeffY1;
        int eRes = Nres1 + Mres2;
        int Y = eRes / eY;
        System.out.println("Y = " + Y);
        System.out.println("res = " + eRes);

        // Find X based on Y

        int nX = res1 - coeffY1 * Y;
        int X = nX / coeffX1;
        System.out.println("X = " + X);

        xResult.setText("X = " + X);
        yResult.setText("Y = " + Y);

    }
}
