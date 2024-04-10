package com.example.simplecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Intent credit;
    EditText display;
    double num1 = 0, operation = 0, ans = 0, calculatedAns = 0;
    int input_length = 0;
    String temp;
    boolean isPlus = false, isMinus = false, isDivide = false, isTimes = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        credit = new Intent(this,creditScreen.class);
    }

    public void lastAction(String temp) {
        display.setText("");
        num1 = Double.parseDouble(temp);

        if (operation == 1) {
            ans += num1;
        }
        else if (operation == 2) {
            ans -= num1;
        }
        else if (operation == 3) {
            if (num1 != 0) {
                if (ans != 0) {
                    ans /= num1;
                }
                display.setHint("" + ans);
            }
            else {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            }
        }
        else if (operation == 4) {
            if (ans != 0) {
                ans *= num1;
            }
        }
        else {
            ans = num1;
        }
        operation = 0;
        display.setHint("" + ans);
    }


    public boolean check_input(String input) {
        input_length = input.length();
        if(input_length == 1) {
            if((!input.isEmpty() && input.equals("-") != true) && (input.equals(".") != true) && (input.equals("+") != true))
                return true;
        }
        else if (input_length > 0) {
            if((!input.isEmpty() && input.equals("-.") != true) && (input.equals("+.") != true))
                return true;
        }
        if(!isTimes && !isDivide && !isMinus && !isPlus) {
            Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void plusAction(View view) {
        isPlus = true;
        temp = display.getText().toString();
        if(check_input(temp)){
            if(isMinus || isDivide || isTimes)
                lastAction(temp);
            else{
                lastAction(temp);
            }
        }
        else {
            display.setHint(""+ans);
        }
        operation = 1;
    }

    public void minusAction(View view) {
        isMinus = true;
        temp = display.getText().toString();
        if(check_input(temp)){
            if (isPlus || isDivide || isTimes) {
                lastAction(temp);
            }
            else {
                lastAction(temp);
            }
        }
        else {
            display.setHint(""+ans);
        }
        operation = 2;
    }

    public void divideAction(View view) {
        isDivide = true;
        temp = display.getText().toString();
        if(check_input(temp)){
            if (isPlus || isMinus || isTimes) {
                lastAction(temp);
            }
            else {
                lastAction(temp);
            }
        }
        else {
            display.setHint(""+ans);
        }
        operation = 3;
    }

    public void timesAction(View view) {
        isTimes = true;
        temp = display.getText().toString();
        if(check_input(temp)){
            if (isPlus || isMinus || isDivide) {
                lastAction(temp);
            }
            else {
                lastAction(temp);
            }
        }
        else {
            display.setHint(""+ans);
        }
        operation = 4;
    }

    public void resetAction(View view) {
        display.setText("");
        display.setHint("");
        num1 = 0;
        ans = 0;
        operation = 0;
        isPlus = false;
        isMinus = false;
        isDivide = false;
        isTimes = false;
    }

    public void calculateAction(View view) {
        temp = display.getText().toString();
        if(check_input(temp) && (isDivide || isPlus || isMinus || isTimes)) {
            lastAction(temp);
            operation = 0;
            calculatedAns = ans;
            display.setText("");
            display.setHint("" + calculatedAns);
        }
        else {
            display.setHint(""+ans);
        }
    }

    public void creditsScreen(View view) {
        credit.putExtra("ans",calculatedAns);
        startActivity(credit);
    }
}