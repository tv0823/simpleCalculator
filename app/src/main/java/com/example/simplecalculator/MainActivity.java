package com.example.simplecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText display;
    double num1 = 0, operation = 0, ans = 0, calculatedAns = 0;
    String temp;
    boolean isPlus = false, isMinus = false, isDivide = false, isTimes = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

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
        else
            ans = num1;

        operation = 0;
        display.setHint("" + ans);
    }


    public void plusAction(View view) {
        isPlus = true;
        temp = display.getText().toString();
        if(!(temp.isEmpty())){
            if(isMinus || isDivide || isTimes)
                lastAction(temp);
            else{
                display.setText("");
                num1 = Double.parseDouble(temp);
                ans += num1;
                display.setHint("" + ans);
            }
        }
        operation = 1;
    }

    public void minusAction(View view) {
        isMinus = true;
        temp = display.getText().toString();
        if (!temp.isEmpty()) {
            if (isPlus || isDivide || isTimes) {
                lastAction(temp);
            }
            else {
                display.setText("");
                num1 = Double.parseDouble(temp);
                if (ans == 0) {
                    ans = num1;
                }
                else {
                    ans -= num1;
                }
                display.setHint("" + ans);
            }
        }
        operation = 2;
    }

    public void divideAction(View view) {
        isDivide = true;
        temp = display.getText().toString();
        if (!temp.isEmpty()) {
            if (isPlus || isMinus || isTimes) {
                lastAction(temp);
            }
            else {
                display.setText("");
                num1 = Double.parseDouble(temp);
                if (num1 != 0) {
                    if (ans != 0) {
                        ans /= num1;
                    }
                    else {
                        ans = num1;
                    }
                    display.setHint("" + ans);
                }
                else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                }
            }
        }
        operation = 3;
    }

    public void timesAction(View view) {
        isTimes = true;
        temp = display.getText().toString();
        if (!temp.isEmpty()) {
            if (isPlus || isMinus || isDivide) {
                lastAction(temp);
            }
            else {
                display.setText("");
                num1 = Double.parseDouble(temp);
                if (ans != 0) {
                    ans *= num1;
                }
                else {
                    ans = num1;
                }
                display.setHint("" + ans);
            }
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
        if (!temp.isEmpty()) {
            lastAction(temp);
        }

        operation = 0;
        calculatedAns = ans;
        display.setText("");
        display.setHint("" + calculatedAns);
    }

    public void creditsScreen(View view) {
        Intent credit = new Intent(this,creditScreen.class);
        credit.putExtra("ans",calculatedAns);
        startActivity(credit);
    }
}