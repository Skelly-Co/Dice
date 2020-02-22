package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private LinearLayout linDiceContainer;
    private Button btnRoll, btnAddDice, btnRemoveDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeDices();
    }

    private void initializeViews()
    {
        linDiceContainer = findViewById(R.id.linDiceContainer);
        btnRoll = findViewById(R.id.btnRoll);
        btnAddDice = findViewById(R.id.btnAddDice);
        btnRemoveDice = findViewById(R.id.btnRemoveDice);
    }

    private void initializeDices()
    {
        linDiceContainer.addView(new Dice(this));
    }
}
