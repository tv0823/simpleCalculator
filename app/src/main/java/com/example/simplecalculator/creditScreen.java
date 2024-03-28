package com.example.simplecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class creditScreen extends AppCompatActivity {
    TextView lastAns;
    double ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_screen);

        lastAns = findViewById(R.id.lastAns);
        Intent getCredit = getIntent();
        ans = getCredit.getDoubleExtra("ans", 0);
        lastAns.setText("The last answer is: " + ans);
    }

    public void goBack(View view) {
        finish();
    }
}