package com.example.simplecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText display;
    double num1, operation = 0, ans = 0, calculatedAns = 0;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

    }

    public void plusAction(View view) {
        temp = display.getText().toString();
        if(!(temp.isEmpty())){
            display.setText("");
            num1 = Double.parseDouble(temp);
            if(operation == 2){
                ans -= num1;
                display.setHint("" + ans);
            }
            else if(operation == 3){

            }
            else if(operation == 4){

            }
            else {
                ans += num1;
                display.setHint("" + ans);
            }
        }
        operation = 1;
    }

    public void minusAction(View view) {
        temp = display.getText().toString();
        if(!(temp.isEmpty())){
            display.setText("");
            num1 = Double.parseDouble(temp);

            if(operation == 1) {
                ans += num1;
                display.setHint("" + ans);
            }
            else if(operation == 3){

            }
            else if(operation == 4){

            }
            else{
            ans -= num1;
            display.setHint("" + ans);
            }
        }
        operation = 2;
    }

    public void divideAction(View view) {
        operation = 3;
    }

    public void timesAction(View view) {
    }

    public void resetAction(View view) {
        display.setText("");
        display.setHint("Enter num");
        num1 = 0;
        ans = 0;
        operation = 0;
    }

    public void calculateAction(View view) {
        temp = display.getText().toString();
        if(!(temp.isEmpty())) {
            if(operation == 1) {
                num1 = Double.parseDouble(temp);
                ans += num1;
            }
            else if(operation == 2){
                num1 = Double.parseDouble(temp);
                ans -= num1;
            }
        }
        display.setText("");
        calculatedAns = ans;
        display.setHint("" + calculatedAns);
    }

    public void creditsScreen(View view) {
        Intent credit = new Intent(this,creditScreen.class);
        credit.putExtra("ans",calculatedAns);
        startActivity(credit);
    }
}